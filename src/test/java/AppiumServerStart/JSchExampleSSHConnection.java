package AppiumServerStart;

import java.io.IOException;
import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class JSchExampleSSHConnection {

	public void stopServer() {
		String[] command = { "/usr/bin/killall", "-KILL", "node" };
		try {
			Runtime.getRuntime().exec(command);
			System.out.println("Appium server stopped.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// service.stop();
	}

	public void runOnRemoteMac(String addressIp, int portNum) {
		String host = "172.16.12.3";
		String user = "pintu";
		String password = "Summer@12";
		Session session;
		// int x = portNum;
		// String l = "-l";
		String command1 = "\n" + "export ANDROID_HOME=/Users/pintu/Library/Android/sdk\n"
				+ "export PATH=\"${HOME}/Library/Android/sdk/tools:${HOME}/Library/Android/sdk/platform-tools:${PATH}\"\n"
				+ "\n"
				+ "export PATH=${HOME}/Library/Android/sdk/tools:${HOME}/Library/Android/sdk/platform-tools:${PATH}\n"
				+ "\n" + "export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-9.0.4.jdk/Contents/Home\n"
				+ "export PATH=${JAVA_HOME}/bin:$PATH\n" + "\n"
				+ "export M2_HOME=/usr/local/Cellar/maven/3.5.4/libexec\n" + "export PATH=$PATH:$M2_HOME/bin\n" + "\n"
				+ "export PATH=/usr/local/bin:$PATH\n" + "\n" + "\n" + "appium --address " + addressIp + "-p "
				+ portNum;
		try {

			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			JSch jsch = new JSch();
			session = jsch.getSession(user, host, 22);
			session.setPassword(password);
			session.setConfig(config);
			session.connect();
			System.out.println("Connected");

			Channel channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand(command1);
			channel.setInputStream(null);
			((ChannelExec) channel).setErrStream(System.err);

			InputStream in = channel.getInputStream();
			channel.connect();
			byte[] tmp = new byte[1024];
			long t = System.currentTimeMillis();
			long end = t + 15000;
			while (System.currentTimeMillis() < end) {
				while (in.available() > 0) {
					int i = in.read(tmp, 0, 1024);
					if (i < 0)
						break;
					System.out.print(new String(tmp, 0, i));
				}
				if (channel.isClosed()) {
					System.out.println("exit-status: " + channel.getExitStatus());
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (Exception ee) {
				}
			}
			channel.disconnect();
			session.disconnect();
			System.out.println("DONE");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// JSchExampleSSHConnection ref1 = new JSchExampleSSHConnection();

		// ref1.stopServer();
	}
}
