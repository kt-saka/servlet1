package biz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sample {

	public static void main(String[] args) {

		Connection con = null;

		PreparedStatement ps = null;

		try {

			// �h���C�o�N���X�����[�h
			Class.forName("com.mysql.jdbc.Driver");

			// �f�[�^�x�[�X�֐ڑ�
			con = DriverManager.getConnection("jdbc:mysql://localhost/Sample_db", "id", "passwd");

			// name,bloodType,age�̃f�[�^����������SQL�����쐬
			String sql = "select name,bloodType,age from Sample_Table";

			// �X�e�[�g�����g�I�u�W�F�N�g�𐶐�
			ps = con.prepareStatement(sql);

			// �N�G���[�����s���Č��ʃZ�b�g���擾
			ResultSet rs = ps.executeQuery();

			// �������ꂽ�s�������[�v
			while (rs.next()) {

				// name�f�[�^���擾
				String name = rs.getString("name");
				// bloodType�f�[�^���擾
				String bloodType = rs.getString("bloodType");
				// age�f�[�^���擾
				String age = rs.getString("age");

				// �f�[�^�̕\��
				System.out.println("name;" + " " + name);
				System.out.println("bloodType;" + " " + bloodType);
				System.out.println("age;" + " " + age);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {

				// close����
				if (ps != null) {
					ps.close();
				}

				// close����
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}