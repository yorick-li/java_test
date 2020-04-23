package org.design_pattern.observer_pattern.scene1;

/**
 * 通知接口
 * @author hspcadmin
 *
 */
public interface Notice {
	
	<T> void notice(Info info, Wife wife);

}
