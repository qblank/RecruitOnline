package cn.qblank.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * 产生验证码的工具类
 * @author evan_qb
 *
 */
public class VerifyCode {
	private int w = 80;
	private int h = 30;
	
	private Random random = new Random();
	
	private String[] fontNames = {"宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312"};
	private String codes = "123456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";
	private Color bgColor = new Color(255, 255, 255);
	private String text;
	
	/**
	 * 产生随机颜色
	 * @return
	 */
	private Color randomColor() {
		int red = random.nextInt(254);
		int green = random.nextInt(254);
		int blue = random.nextInt(254);
		return new Color(red, green, blue);
	}
	
	/**
	 * 产生随机字体
	 * @return
	 */
	private Font randomFont() {
		int index = random.nextInt(fontNames.length);
		String fontName	= fontNames[index];
		int style = random.nextInt(4);
		int size = random.nextInt(5) + 24;
		return new Font(fontName, style, size);
	}
	
	/**
	 * 随机画线
	 */
	private void drawLine(BufferedImage image) {
		int num = 3;
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		for (int i = 0; i < num; i++) {
			int x1 = random.nextInt(w);
			int x2 = random.nextInt(w);
			int y1 = random.nextInt(h);
			int y2 = random.nextInt(h);
			g2.setStroke(new BasicStroke(1.5F));
			g2.setColor(Color.BLUE);
			g2.drawLine(x1, y1, x2, y2);
		}
	}
	
	/**
	 * 产生随机字母
	 * @return
	 */
	private char randomChar() {
		int index = random.nextInt(codes.length());
		return codes.charAt(index);
	}
	
	/**
	 * 产生图片
	 * @return
	 */
	private BufferedImage createImage() {
		BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		g2.setColor(this.bgColor);
		return image;
	}
	
	/**
	 * 获取图片
	 * @return
	 */
	public BufferedImage getImage() {
		BufferedImage image = createImage();
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		StringBuffer sb = new StringBuffer();
		//向图中画出四个字符
		for (int i = 0; i < 4; i++) {
			String s = randomChar() + "" ;
			sb.append(s);
			//计算间隔
			float x = i * 1.0F * w /4;
			g2.setFont(randomFont());
			g2.setColor(randomColor());
			g2.drawString(s, x, h - 5);
		}
		this.text = sb.toString();
		drawLine(image);
		return image;
	}
	
	public String getText() {
		return text;
	}
	
	/**
	 * 输出为图片
	 * @param image
	 * @param out
	 */
	public static void output(BufferedImage image,OutputStream out) throws Exception{
		ImageIO.write(image, "JPEG", out);
	}
	
}
