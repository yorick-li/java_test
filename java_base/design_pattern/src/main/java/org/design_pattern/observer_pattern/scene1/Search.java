package org.design_pattern.observer_pattern.scene1;

/**
 * 接口：搜索证据
 * @author hspcadmin
 *
 */
public interface Search {
	
	/**
	 * 搜集证据
	 * @param husband
	 * @return
	 */
	void search(Husband husband, Wife wife);
	
}
