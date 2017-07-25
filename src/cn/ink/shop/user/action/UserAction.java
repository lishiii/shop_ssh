package cn.ink.shop.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.ink.shop.user.service.UserService;
import cn.ink.shop.user.vo.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * �û�ģ��Action����
 * 
 * @author Ink4T
 * 
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
	// ģ������ʹ�õĶ���
	private User user = new User();

	public User getModel() {
		return user;
	}

	// ע��UserService
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * ��ת��ע��ҳ��
	 * 
	 * @return
	 */
	public String registPage() {
		return "registPage";
	}

	/**
	 * AJAX�����첽�����û��ķ���
	 * 
	 * @throws IOException
	 * 
	 */
	public String findByName() throws IOException {
		// ����Service���в�ѯ:
		User existUser = userService.findByUsername(user.getUsername());
		// ���response����,��ҳ�����:
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// �ж�
		if (existUser != null) {
			// ��ѯ�����û�:�û����Ѿ�����
			// System.out.println(existUser.getUsername());
			response.getWriter().println("<font color='red'>�û����Ѿ�����</font>");

		} else {
			// û��ѯ�����û�:�û�������ʹ��
			// System.out.println(existUser.getUsername());
			response.getWriter().println("<font color='green'>�û�������ʹ��</font>");

		}
		return NONE;
	}

	/**
	 * �û�ע��ķ���:
	 */
	public String regist() {
		// �ж���֤�����:
		// ��session�л����֤������ֵ:
		String checkcode1 = (String) ServletActionContext.getRequest()
				.getSession().getAttribute("checkcode");
		if (!checkcode1.equalsIgnoreCase(checkcode1)) {
			this.addActionError("��֤���������!");
			return "checkcodeFail";
		}
		userService.save(user);
		this.addActionMessage("ע��ɹ�!��ȥ���伤��!");
		return "msg";
	}

	public String active() {
		// ���ݼ������ѯ�û�:
		User existUser = userService.findByCode(user.getCode());
		// �ж�
		if (existUser == null) {
			// ����������
			this.addActionMessage("����ʧ��:���������!");
		} else {
			// ����ɹ�
			// �޸��û���״̬
			existUser.setState(1);
			existUser.setCode(null);
			userService.update(existUser);
			this.addActionMessage("����ɹ�:��ȥ��¼!");
		}
		return "msg";
	}

	/**
	 * ��¼�ķ���
	 */
	public String login() {
		User existUser = userService.login(user);
		// �ж�
		if (existUser == null) {
			// ��¼ʧ��
			this.addActionError("��¼ʧ��:�û��������������û�δ����!");
			return "login";
		} else {
			// ��¼�ɹ�
			// ���û�����Ϣ���뵽session��
			ServletActionContext.getRequest().getSession()
					.setAttribute("existUser", existUser);
			// ҳ����ת
			return "loginSuccess";
		}
	}

	/**
	 * �û��˳��ķ���
	 */
	public String quit() {
		// ����session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	
	/**
	 * ��ת����¼ҳ��
	 */
	public String loginPage() {
		return "loginPage";
	}
}
