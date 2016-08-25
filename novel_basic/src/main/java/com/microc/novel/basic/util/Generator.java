package com.microc.novel.basic.util;

import java.io.Serializable;
import java.net.InetAddress;

public class Generator {

	private static final int IP;

	static {
		int ipadd;
		try {
			ipadd = toInt(InetAddress.getLocalHost().getAddress());
		} catch (Exception e) {
			ipadd = 0;
		}
		IP = ipadd;
	}

	private static final int JVM = (int) (System.currentTimeMillis() >>> 8);

	private static Short counter = (short)0;

	public static Serializable generate(char c) {

		return new StringBuffer(36)
		.append(format(getIP())).append(c)
		.append(format(getJVM())).append(c)
		.append(format(getHiTime())).append(c)
		.append(format(getLoTime())).append(c)
		.append(format(getCount())).toString();
	}

	public static Serializable generate() {

		return new StringBuffer(32).append(format(getIP())).append(format(getJVM()))

		.append(format(getHiTime())).append(format(getLoTime()))

		.append(format(getCount())).toString();
	}

	protected synchronized static short getCount() {

		synchronized (counter) {

			if (counter >= Short.MAX_VALUE) counter = (short)0;

			return counter++;
		}
	}

	protected static int getJVM() {
		return JVM;
	}

	protected static int getIP() {
		return IP;
	}

	private static short getHiTime() {
		return (short) (System.currentTimeMillis() >>> 32);
	}

	private static int getLoTime() {
		return (int) System.currentTimeMillis();
	}

	private static String format(int intValue) {
		String formatted = Integer.toHexString(intValue);
		StringBuffer buf = new StringBuffer("00000000");
		buf.replace(8 - formatted.length(), 8, formatted);
		return buf.toString();
	}

	private static String format(short shortValue) {
		String formatted = Integer.toHexString(shortValue);
		System.out.println("formatted = " + formatted);
		StringBuffer buf = new StringBuffer("0000");
		buf.replace(4 - formatted.length(), 4, formatted);
		return buf.toString();
	}

	private static int toInt(byte[] bytes) {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			result = (result << 8) - Byte.MIN_VALUE + (int) bytes[i];
		}
		return result;
	}
}
