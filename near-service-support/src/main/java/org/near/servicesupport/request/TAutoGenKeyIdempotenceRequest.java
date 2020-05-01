package org.near.servicesupport.request;

@Deprecated
public class TAutoGenKeyIdempotenceRequest<T> extends AutoGenKeyIdempotenceRequest {
	private static final long serialVersionUID = 7872509416543925758L;
	protected T condition;
	public T getCondition() {
		return condition;
	}
	public void setCondition(T condition) {
		this.condition = condition;
	}
	
}
