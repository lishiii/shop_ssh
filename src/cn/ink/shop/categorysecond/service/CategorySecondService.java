package cn.ink.shop.categorysecond.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.ink.shop.categorysecond.dao.CategorySecondDao;
import cn.ink.shop.categorysecond.vo.CategorySecond;
import cn.ink.shop.utils.PageBean;

@Transactional
public class CategorySecondService {
	// ע��Dao
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

	// ����������з�ҳ�Ĳ�ѯ����:
	public PageBean<CategorySecond> findByPage(Integer page) {
		PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();

		// ���ò���:
		pageBean.setPage(page);
		// ����ÿҳ��ʾ��¼��:
		int limit = 10;
		pageBean.setLimit(limit);
		// �����ܼ�¼��:
		int totalCount = categorySecondDao.findCount();
		pageBean.setTotalCount(totalCount);
		// ������ҳ��:
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// ����ҳ����ʾ���ݵļ���:
		int begin = (page - 1) * limit;
		List<CategorySecond> list = categorySecondDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	// ҵ���ı����������Ĳ���
	public void save(CategorySecond categorySecond) {
		categorySecondDao.save(categorySecond);
	}

	// ҵ����ɾ����������Ĳ���
	public void delete(CategorySecond categorySecond) {
		categorySecondDao.delete(categorySecond);
	}

	// ҵ������id��ѯ��������
	public CategorySecond findByCsid(Integer csid) {
		return categorySecondDao.findByCsid(csid);
	}

	// ҵ����޸Ķ�������ķ���
	public void update(CategorySecond categorySecond) {
		categorySecondDao.update(categorySecond);
	}

	// ҵ����ѯ���ж�������(������ҳ)
	public List<CategorySecond> findAll() {
		return categorySecondDao.findAll();
	}
}
