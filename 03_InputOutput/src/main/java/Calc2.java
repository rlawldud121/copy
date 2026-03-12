

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OddEven
 */
@WebServlet("/Calc2")
public class Calc2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int xx = Integer.parseInt(request.getParameter("x"));
		int yy = Integer.parseInt(request.getParameter("y"));
		String[] op = request.getParameterValues("oper");
		
		System.out.println(xx);
		System.out.println(yy);
		
		// 브라우저에 뭘 쓰고 싶음 (html)
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("</head>");
		
		out.print("<body>");
		
		out.print("<div style=\"width : 500px; background-color: ivory; border: 2px solid\">");
		
		for (String operator : op) {
			// a, b
			if (operator.equals("+")) {
				out.printf("<div>%d + %d = %d</div>", xx, yy, xx+yy);
			} else if (operator.equals("-")) {
				out.printf("<div>%d - %d = %d</div>", xx, yy, xx-yy);
			} else if (operator.equals("x")) {
				out.printf("<div>%d x %d = %d</div>", xx, yy, xx*yy);
			} else if (operator.equals("/")) {
				if (yy != 0) {
					// 소수점의 경우에만 double로 표시, 일반은 정수로 표시하고 싶은 경우 = DecimalFormat(데시멀포맷)
					double result = xx / (double)yy;
				DecimalFormat df = new DecimalFormat("#.##");
				String ttt = df.format(result);
					out.printf("<div>%d / %d = %s</div>", xx, yy, ttt);
				} else {
					out.printf("<div>0으로 나눌 수 없습니다</div>");
				}
			}
		}
		
		
		out.print("</div>");
		
		out.print("</body>");
		
		out.print("</html>");
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
