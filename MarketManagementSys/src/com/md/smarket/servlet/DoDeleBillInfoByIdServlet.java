package MarketManagementSys.src.com.md.smarket.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.md.smarket.dao.BillDao;
import com.md.smarket.dao.impl.BillDaoImpl;
import com.md.smarket.entity.Bill;
import com.md.smarket.entity.PageSize;
import com.md.smarket.service.impl.BillMangeServiceImpl;

public class DoDeleBillInfoByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int billId = Integer.parseInt(request.getParameter("billId").trim());
		BillMangeServiceImpl billMangeServiceImpl = new BillMangeServiceImpl();
		BillDao billDao = new BillDaoImpl();
		billMangeServiceImpl.setBillDao(billDao);
		int result = billMangeServiceImpl.deleteBillInfo(billId);
		if (result == 1) {
			List<Bill> billList = billMangeServiceImpl.getAllBillsInfo();
			PageSize pageSize=billMangeServiceImpl.getPageBillInfo(1);
		    pageSize.setList(billList);
			request.setAttribute("page", pageSize);
			request.setAttribute("billList", billList);
			request.getRequestDispatcher("admin_bill_list.jsp").forward(request, response);
		}

	}

}
