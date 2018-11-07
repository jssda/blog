/**
 * 生成验证码 
 */
package pers.jssd.blog.servlet;

import java.io.*;
import com.sun.image.codec.jpeg.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.awt.*;
import java.awt.image.*;

/**
 * @author jssd
 *
 */

@WebServlet(name="ValidateImageServlet", urlPatterns="/ValidateImageServlet")
public class ValidateImageServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Font font = new Font("Courier", Font.BOLD, 22); // 字体
	private int ValidateCodeLength = 4;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 得到待显示的数字
		String count = "";
		for (int i = 0; i < ValidateCodeLength; i++) {
			count = count + (int) (1 + Math.random() * (10 - 1));
		}

		HttpSession session = request.getSession();
		session.setAttribute("validateCode", count);
System.out.println(count);

		int len = count.length(); // 数字的长度

		response.setContentType("image/jpeg");
		ServletOutputStream out = response.getOutputStream();
		// 创建一个位于缓存中的图像，长为11*len，高为16
		BufferedImage image = new BufferedImage(15 * len, 25, BufferedImage.TYPE_INT_RGB);

		// 获得Graphics画笔
		Graphics g = image.getGraphics();
		g.setColor(Color.black);
		// 画一个黑色的矩形，长为11*len，高为16
		g.fillRect(0, 0, 15 * len, 25);

		g.setColor(Color.white);
		g.setFont(font);

		char c;
		for (int i = 0; i < len; i++) {
			c = count.charAt(i);
			g.drawString(c + "", i * 15 + 1, 25); // 写一个白色的数字
			g.drawLine((i + 2) * 15 - 2, 0, (i + 2) * 15 - 1, 22); // 画一个白色的竖线
		}

		// 输出JPEG格式的图片
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(image);
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}