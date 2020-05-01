package org.near.servicesupport.request;

// FIXME 由于很多服务依赖 PageRequest，但未升级这个包，后续再切换成 AbstractServiceRequest
@Deprecated
public abstract class TIdempotenceRequest<T> extends BaseRequest {
	private static final long serialVersionUID = 7207770869975508959L;
	protected T condition;
	public T getCondition() {
		return condition;
	}
	public void setCondition(T condition) {
		this.condition = condition;
	}
	
}
