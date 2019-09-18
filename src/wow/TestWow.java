package wow;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;

public class TestWow {

	public static void main(String[] args) {
		// 注册热键 ctrl+W，当触发的时候，带上key值：1
		JIntellitype.getInstance().registerHotKey(1, JIntellitype.MOD_CONTROL, (int) 'W');
		// 注册热键 alt+F，当触发的时候，带上key值：2
		JIntellitype.getInstance().registerHotKey(2, JIntellitype.MOD_ALT, (int) 'F');

		//加上热键监听器
		JIntellitype.getInstance().addHotKeyListener(new HotkeyListener() {
			@Override
			public void onHotKey(int k) {
				//通过判断k的值来剪间接地知道是触发了哪个热键，比如这里是1，就表示触发了 ctrl+W
				if (1 == k) {
					try {
						//启动机器人。。。
						Robot robot=new Robot();
						//暂停半秒
						Thread.sleep(500);

						//狂按5秒钟的c键，每下间隔 300毫秒
						for (int i = 0; i < 17; i++) {
							//按下C键
							robot.keyPress(KeyEvent.VK_C);
							//弹起C键 
							//注： 一次按下，加上一次弹起，才能组合成一个点击
							robot.keyRelease(KeyEvent.VK_C);
							//间隔300毫秒
							Thread.sleep(300);
						}

					} catch (AWTException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				//通过判断k的值来剪间接地知道是触发了哪个热键，比如这里是2，就表示触发了 alt+f
				if (2 == k) {
					try {
						
						
						Robot robot = null;
						robot = new Robot();
						Thread.sleep(500);
						
						//一下组合的意思是挨个点击 2,3,4,1，每次点击之间间隔 1.5秒。因为魔兽世界每个瞬发技能公共CD是 1.5秒，需要经过 1.5秒之后，才能点击下一个技能
						robot.keyPress(KeyEvent.VK_2);
						robot.keyRelease(KeyEvent.VK_2);

						Thread.sleep(1500);
						robot.keyPress(KeyEvent.VK_3);
						robot.keyRelease(KeyEvent.VK_3);

						Thread.sleep(1500);
						robot.keyPress(KeyEvent.VK_4);
						robot.keyRelease(KeyEvent.VK_4);
						
						Thread.sleep(1500);
						robot.keyPress(KeyEvent.VK_1);
						robot.keyRelease(KeyEvent.VK_1);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		});
	}
}
