package ch.zhaw.iwi.devops.service.module;

import com.google.inject.Inject;
import com.google.inject.Injector;

import ch.zhaw.iwi.devops.model.user.User;
import ch.zhaw.iwi.devops.service.AbstractCrudRestService;

public class ModuleRestService extends AbstractCrudRestService<User, Long, ModuleDatabaseService> {

	@Inject
	public ModuleRestService(Injector injector) {
		super(injector, ModuleDatabaseService.class);
	}

}