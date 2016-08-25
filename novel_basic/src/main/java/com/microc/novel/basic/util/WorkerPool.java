package com.microc.novel.basic.util;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class WorkerPool extends ThreadPoolExecutor {

	private static final Logger LOG = Logger.getLogger(WorkerPool.class.getName());

	public WorkerPool(int maxSize) {

		this(0, maxSize, 60L, TimeUnit.SECONDS, false);
	}

	public WorkerPool(int minSize, int maxSize) {

		this(minSize, maxSize, 60L, TimeUnit.SECONDS, false);
	}

	public WorkerPool(int minSize, int maxSize, int taskqueuesize) {

		this(minSize, maxSize, 60L, TimeUnit.SECONDS, taskqueuesize, false);
	}

	public WorkerPool(int minSize, int maxSize, long keepalive, TimeUnit timeunit, boolean isDaemon) {

		this(minSize, maxSize, keepalive, timeunit, 2147483647, isDaemon);
	}

	public WorkerPool(int minSize, int maxSize, long keepalive, TimeUnit timeunit, int taskqueuesize, boolean isDaemon) {

		super(minSize, maxSize, keepalive, timeunit, new WorkerPoolAwareQueue(taskqueuesize), new DefaultThreadFactory(isDaemon));

		((WorkerPoolAwareQueue) getQueue()).init(this);
	}

	private static class DefaultThreadFactory implements ThreadFactory {

		private static final AtomicInteger poolNumber = new AtomicInteger(1);

		private final AtomicInteger threadNumber = new AtomicInteger(1);

		private final String namePrefix;

		private final boolean isDaemon;

		DefaultThreadFactory(boolean isDaemon) {

			this.isDaemon = isDaemon;

			this.namePrefix = "xWorkerPool-" + poolNumber.getAndIncrement() + "-thread-";
		}

		public Thread newThread(Runnable r) {

			if (WorkerPool.LOG.isLoggable(Level.FINE)) {

				WorkerPool.LOG.fine("creating new thread");
			}

			Thread t = new Thread(r, this.namePrefix + this.threadNumber.getAndIncrement());

			t.setDaemon(this.isDaemon);

			if (t.getPriority() != 5) {

				t.setPriority(5);
			}
			return t;
		}
	}

	private static final class WorkerPoolAwareQueue extends LinkedBlockingQueue<Runnable> {

		private static final long serialVersionUID = -2186255280833948026L;

		private WorkerPool workerPool;

		public WorkerPoolAwareQueue(int capacity) {

			super(capacity);
		}

		public void init(WorkerPool workerPool) {

			this.workerPool = workerPool;
		}

		public boolean offer(Runnable task) {

			if (this.workerPool.getActiveCount() < this.workerPool.getPoolSize()) {

				return super.offer(task);
			}
			if (this.workerPool.getPoolSize() >= this.workerPool.getMaximumPoolSize()) {

				if (WorkerPool.LOG.isLoggable(Level.FINE)) {

					WorkerPool.LOG.fine("add task to queue waiting for the next free one");
				}
				return super.offer(task);
			}
			if (WorkerPool.LOG.isLoggable(Level.FINE)) {

				WorkerPool.LOG.fine("initiate creating a new thread");
			}
			return false;
		}
	}
}