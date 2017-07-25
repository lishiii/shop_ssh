package cn.ink.shop.categorysecond.adminaction;

import java.util.List;

import cn.ink.shop.category.service.CategoryService;
import cn.ink.shop.category.vo.Category;
import cn.ink.shop.categorysecond.service.CategorySecondService;
import cn.ink.shop.categorysecond.vo.CategorySecond;
import cn.ink.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminCategorySecondAction extends ActionSupport implements
		ModelDriven<CategorySecond> {
	// ģ������ʹ�õĶ���
	private CategorySecond categorySecond = new CategorySecond();

	public CategorySecond getModel() {
		return categorySecond;
	}

	// ����page����:
	private Integer page;
	// ע�����Service
	private CategorySecondService categorySecondService;
	// ע��һ�������Service
	private CategoryService categoryService;

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setCategorySecondService(
			CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	// ���з�ҳ�Ĳ�ѯ���ж�������Ĳ���:
	public String findAll() {
		// ����Service���в�ѯ.
		PageBean<CategorySecond> pageBean = categorySecondService
				.findByPage(page);
		// ��pageBean�����ݴ��뵽ֵջ��.
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}

	// ��ת�����ҳ��ķ���:
	public String addPage() {
		// ��ѯ����һ������.
		List<Category> cList = categoryService.findAll();
		// �����ϴ��뵽ֵջ��.
		ActionContext.getContext().getValueStack().set("cList", cList);
		// ҳ����ת:
		return "addPage";
	}

	// ��Ӷ�������ķ���:
	public String save() {
		categorySecondService.save(categorySecond);
		return "saveSuccess";
	}

	// ɾ����������ķ���:
	public String delete() {
		categorySecondService.delete(categorySecond);
		return "deleteSuccess";
	}

	// �༭��������ķ���:
	public String edit() {
		// ����id��ѯ��������:
		// System.out.println(categorySecond.getCsid()+"================================");
		categorySecond = categorySecondService.findByCsid(categorySecond
				.getCsid());
		// System.out.println(categorySecond+"==========================categorySecond");
		// ��ѯ����һ������:
		List<Category> cList = categoryService.findAll();
		System.out.println(cList + "===================================cList");
		// �����ϴ��뵽ֵջ��.
		ActionContext.getContext().getValueStack().set("cList", cList);
		// ҳ����ת:
		return "editSuccess";
	}

	// �޸Ķ�������ķ���:
	public String update() {
		categorySecondService.update(categorySecond);
		return "updateSuccess";
	}
}
