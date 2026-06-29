/**
 */
package excelltsmetamodel.provider;

import excelltsmetamodel.ExcelltsmetamodelPackage;
import excelltsmetamodel.Lookup;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link excelltsmetamodel.Lookup} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LookupItemProvider extends FlowStepItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LookupItemProvider(AdapterFactory adapterFactory) {
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

			addTablePropertyDescriptor(object);
			addLookupTablePropertyDescriptor(object);
			addColumnPropertyDescriptor(object);
			addOperandColumnPropertyDescriptor(object);
			addMatchColumnPropertyDescriptor(object);
			addLookupColumnPropertyDescriptor(object);
			addResultColumnPropertyDescriptor(object);
			addOperationPropertyDescriptor(object);
			addResultTablePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Table feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTablePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Lookup_table_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Lookup_table_feature", "_UI_Lookup_type"),
						ExcelltsmetamodelPackage.Literals.LOOKUP__TABLE, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Lookup Table feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLookupTablePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Lookup_lookupTable_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Lookup_lookupTable_feature",
								"_UI_Lookup_type"),
						ExcelltsmetamodelPackage.Literals.LOOKUP__LOOKUP_TABLE, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Column feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addColumnPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Lookup_column_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Lookup_column_feature", "_UI_Lookup_type"),
						ExcelltsmetamodelPackage.Literals.LOOKUP__COLUMN, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Operand Column feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOperandColumnPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Lookup_operandColumn_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Lookup_operandColumn_feature",
								"_UI_Lookup_type"),
						ExcelltsmetamodelPackage.Literals.LOOKUP__OPERAND_COLUMN, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Match Column feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMatchColumnPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Lookup_matchColumn_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Lookup_matchColumn_feature",
								"_UI_Lookup_type"),
						ExcelltsmetamodelPackage.Literals.LOOKUP__MATCH_COLUMN, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Lookup Column feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLookupColumnPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Lookup_lookupColumn_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Lookup_lookupColumn_feature",
								"_UI_Lookup_type"),
						ExcelltsmetamodelPackage.Literals.LOOKUP__LOOKUP_COLUMN, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Result Column feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResultColumnPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Lookup_resultColumn_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Lookup_resultColumn_feature",
								"_UI_Lookup_type"),
						ExcelltsmetamodelPackage.Literals.LOOKUP__RESULT_COLUMN, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Operation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOperationPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Lookup_operation_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Lookup_operation_feature",
								"_UI_Lookup_type"),
						ExcelltsmetamodelPackage.Literals.LOOKUP__OPERATION, true, false, false,
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
						getResourceLocator(), getString("_UI_Lookup_resultTable_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Lookup_resultTable_feature",
								"_UI_Lookup_type"),
						ExcelltsmetamodelPackage.Literals.LOOKUP__RESULT_TABLE, true, false, true, null, null, null));
	}

	/**
	 * This returns Lookup.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Lookup"));
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
		String label = ((Lookup) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_Lookup_type")
				: getString("_UI_Lookup_type") + " " + label;
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

		switch (notification.getFeatureID(Lookup.class)) {
		case ExcelltsmetamodelPackage.LOOKUP__OPERATION:
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
