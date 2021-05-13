package ch.zhaw.iwi.devops.service.module;

import java.util.List;

import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import ch.zhaw.iwi.devops.model.module.Module;
import ch.zhaw.iwi.devops.model.module.Module_;
import ch.zhaw.iwi.devops.service.AbstractCrudDatabaseService;
import ch.zhaw.iwi.devops.service.PathListEntry;

public class ModuleDatabaseService extends AbstractCrudDatabaseService<Module, Long> {

	@Override
	public Class<Module> getEntityClass() {
		return Module.class;
	}

	@Override
	protected void orderBy(Root<Module> root, List<Order> orderList) {
		orderList.add(getCriteriaBuilder().asc(root.get(Module_.name)));
	}

	@Override
	public void createPathListEntry(Module entity, PathListEntry<Long> entry) {
		entry.setKey(entity.getKey(), getKeyName());
		entry.setName(entity.getName());
		entry.getDetails().add(entity.getDescription());
	}

}
