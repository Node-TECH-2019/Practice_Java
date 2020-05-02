package info.searchman.lesson.java_mysql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// DB�֘A�̏����ݒ�
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		// �����R�[�h�̐ݒ�
		request.setCharacterEncoding("Windows-31J");

		// index.jsp�œ��͂���name�̎擾
		String name = request.getParameter("name");

		// index.jsp�œ��͂���id�̎擾
		String id = request.getParameter("id");

		// index.jsp�œ��͂���sei�̎擾
		String sei = request.getParameter("sei");

		// index.jsp�œ��͂���nen�̎擾
		String nen = request.getParameter("nen");
		
	
		try {
			// JDBC Driver �̓o�^
			Class.forName("com.mysql.jdbc.Driver");
			// Connection�̍쐬
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company_db?serverTimezone=UTC&useSSL=false",
					"suser", "spass");

			// sql���쐬�̏���
			StringBuffer sql = new StringBuffer();

			// sql�� �̍쐬�iname����j
			sql.append("select id, name, sei, nen, address from shain_table where name like '%");
			sql.append(name + "%'");

			// id���I������Ă���ꍇ�́A�ǉ�����
			if (id != "") {
				sql.append("and id ='" + id + "'");
			}

			// sei���I������Ă���ꍇ�́A�ǉ�����
			if (sei != "") {
				sql.append("and sei ='" + sei + "'");
			}

			// nen���I������Ă���ꍇ�́A�ǉ�����
			if (nen != "") {
				sql.append("and nen ='" + nen + "'");
			}

			// sql����\��
			System.out.println(sql);

			// sql�����s����
			pstmt = conn.prepareStatement(new String(sql));

			// sql�����s
			pstmt.execute();

			// ���s���ʂ��AResultSet�N���X�ɑ��
			rset = pstmt.executeQuery();

			// �J�ڃy�[�W�ցA���n���iAttribute�Œǉ�����j
			request.setAttribute("kekka", rset);

			// search.jsp�֑J��
			request.getRequestDispatcher("/search.jsp").forward(request, response);

			// �g�p�����I�u�W�F�N�g���I��������
			rset.close();
			pstmt.close();
			conn.close();

		} catch (Exception e) {
//			e.printStackTrace();
//			
//			String status ="�����Ɏ��s���܂����B�Ǘ��҂ɘA�����Ă��������B";					
//			request.setAttribute("status", status);
//			request.getRequestDispatcher("/result.jsp").forward(request, response);

		} finally {
			try {
				// �O�̂��߁Afinally��DB�Ƃ̐ڑ���ؒf���Ă���
				conn.close();
			} catch (Exception e) {
			}
		}

	}

}
