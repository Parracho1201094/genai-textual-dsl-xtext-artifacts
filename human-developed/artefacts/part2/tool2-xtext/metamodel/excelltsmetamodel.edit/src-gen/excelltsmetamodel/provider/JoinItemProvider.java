/**
 */
package excelltsmetamodel.provider;

import excelltsmetamodel.ExcelltsmetamodelPackage;
import excelltsmetamodel.Join;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link excelltsmetamodel.Join} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class JoinItemProvider extends FlowStepItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoinItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addTableLeftPropertyDescriptor(object);
			addTableRightPropertyDescriptor(object);
			addColumnLeftPropertyDescriptor(object);
			addColumnRightPropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addResultTablePropertyDescriptor(object);
			addSelectColumnsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Table Left feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTableLeftPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Join_tableLeft_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Join_tableLeft_feature", "_UI_Join_type"),
						ExcelltsmetamodelPackage.Literals.JOIN__TABLE_LEFT, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Table Right feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTableRightPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Join_tableRight_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Join_tableRight_feature", "_UI_Join_type"),
						ExcelltsmetamodelPackage.Literals.JOIN__TABLE_RIGHT, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Column Left feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addColumnLeftPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Join_columnLeft_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Join_columnLeft_feature", "_UI_Join_type"),
						ExcelltsmetamodelPackage.Literals.JOIN__COLUMN_LEFT, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Column Right feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addColumnRightPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Join_columnRight_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Join_columnRight_feature",
								"_UI_Join_type"),
						ExcelltsmetamodelPackage.Literals.JOIN__COLUMN_RIGHT, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Join_type_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Join_type_feature", "_UI_Join_type"),
						ExcelltsmetamodelPackage.Literals.JOIN__TYPE, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Result Table feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResultTablePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Join_resultTable_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Join_resultTable_feature",
								"_UI_Join_type"),
						ExcelltsmetamodelPackage.Literals.JOIN__RESULT_TABLE, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Select Columns feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSelectColumnsPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Join_selectColumns_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Join_selectColumns_feature",
								"_UI_Join_type"),
						ExcelltsmetamodelPackage.Literals.JOIN__SELECT_COLUMNS, true, false, true, null, null, null));
	}

	/**
	 * This returns Join.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Join"));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Join) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_Join_type")
				: getString("_UI_Join_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Join.class)) {
		case ExcelltsmetamodelPackage.JOIN__TYPE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
