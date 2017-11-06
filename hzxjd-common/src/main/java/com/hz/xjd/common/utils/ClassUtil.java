package com.hz.xjd.common.utils;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * class的工具类
 *
 */
public class ClassUtil {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Set<Class> getClasses(String packageName, boolean isRecursion) {
		Set<String> classNames = getClassNames(packageName, isRecursion);
		Set classes = new HashSet(classNames.size());

		for (String className : classNames) {
			try {
				classes.add(Class.forName(className));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return classes;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set<String> getClassNames(String packageName, boolean isRecursion) {
		Set classNames = null;
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		String packagePath = packageName.replace(".", "/");
		URL url = loader.getResource(packagePath);
		if (url != null) {
			String protocol = url.getProtocol();
			if (protocol.equals("file")) {
				classNames = getClassNameFromDir(url.getPath(), packageName, isRecursion);
			} else if (protocol.equals("jar")) {
				JarFile jarFile = null;
				try {
					jarFile = ((JarURLConnection)url.openConnection()).getJarFile();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (jarFile != null) {
					classNames = getClassNameFromJar(jarFile.entries(), packageName, isRecursion);
				}
			}
		} else {
			classNames = getClassNameFromJars(((URLClassLoader)loader).getURLs(), packageName, isRecursion);
		}
		return classNames;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static Set<String> getClassNameFromDir(String filePath, String packageName, boolean isRecursion) {
		Set className = new HashSet();
		File file = new File(filePath);
		File[] files = file.listFiles();
		for (File childFile : files) {
			if (childFile.isDirectory()) {
				if (isRecursion) {
					className.addAll(getClassNameFromDir(childFile.getPath(), packageName + "." + childFile.getName(), isRecursion));
				}
			} else {
				String fileName = childFile.getName();
				if ((fileName.endsWith(".class")) && (!fileName.contains("$"))) {
					className.add(packageName + "." + fileName.replace(".class", ""));
				}
			}
		}
		return className;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static Set<String> getClassNameFromJar(Enumeration<JarEntry> jarEntries, String packageName, boolean isRecursion) {
		Set classNames = new HashSet();

		while (jarEntries.hasMoreElements()) {
			JarEntry jarEntry = (JarEntry)jarEntries.nextElement();
			if (!jarEntry.isDirectory()) {
				String entryName = jarEntry.getName().replace("/", ".");
				if ((entryName.endsWith(".class")) && (!entryName.contains("$")) && (entryName.startsWith(packageName))) {
					entryName = entryName.replace(".class", "");
					if (isRecursion) {
						classNames.add(entryName);
					} else if (!entryName.replace(packageName + ".", "").contains(".")) {
						classNames.add(entryName);
					}
				}
			}
		}
		return classNames;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Set<String> getClassNameFromJars(URL[] urls, String packageName, boolean isRecursion) {
		Set classNames = new HashSet();

		for (int i = 0; i < urls.length; i++) {
			String classPath = urls[i].getPath();

			if (!classPath.endsWith("classes/")) {
				JarFile jarFile = null;
				try {
					jarFile = new JarFile(classPath.substring(classPath.indexOf("/")));
				} catch (IOException e) {
					e.printStackTrace();
				}

				if (jarFile != null) {
					classNames.addAll(getClassNameFromJar(jarFile.entries(), packageName, isRecursion));
				}
			}
		}
		return classNames;
	}

}
