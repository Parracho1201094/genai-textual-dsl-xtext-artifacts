/**
 */
package excelltsmetamodel.provider;

import excelltsmetamodel.ExcelltsmetamodelFactory;
import excelltsmetamodel.ExcelltsmetamodelPackage;
import excelltsmetamodel.Model;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link excelltsmetamodel.Model} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
			addLogsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Model_name_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Model_name_feature", "_UI_Model_type"),
						ExcelltsmetamodelPackage.Literals.MODEL__NAME, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Logs feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLogsPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Model_logs_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Model_logs_feature", "_UI_Model_type"),
						ExcelltsmetamodelPackage.Literals.MODEL__LOGS, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ExcelltsmetamodelPackage.Literals.MODEL__TABLES);
			childrenFeatures.add(ExcelltsmetamodelPackage.Literals.MODEL__STEPS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Model.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Model"));
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
		String label = ((Model) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_Model_type")
				: getString("_UI_Model_type") + " " + label;
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

		switch (notification.getFeatureID(Model.class)) {
		case ExcelltsmetamodelPackage.MODEL__NAME:
		case ExcelltsmetamodelPackage.MODEL__LOGS:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case ExcelltsmetamodelPackage.MODEL__TABLES:
		case ExcelltsmetamodelPackage.MODEL__STEPS:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

		newChildDescriptors.add(createChildParameter(ExcelltsmetamodelPackage.Literals.MODEL__TABLES,
				ExcelltsmetamodelFactory.eINSTANCE.createTable()));

		newChildDescriptors.add(createChildParameter(ExcelltsmetamodelPackage.Literals.MODEL__STEPS,
				ExcelltsmetamodelFactory.eINSTANCE.createSave()));

		newChildDescriptors.add(createChildParameter(ExcelltsmetamodelPackage.Literals.MODEL__STEPS,
				ExcelltsmetamodelFactory.eINSTANCE.createGroup()));

		newChildDescriptors.add(createChildParameter(ExcelltsmetamodelPackage.Literals.MODEL__STEPS,
				ExcelltsmetamodelFactory.eINSTANCE.createSort()));

		newChildDescriptors.add(createChildParameter(ExcelltsmetamodelPackage.Literals.MODEL__STEPS,
				ExcelltsmetamodelFactory.eINSTANCE.createAppendRows()));

		newChildDescriptors.add(createChildParameter(ExcelltsmetamodelPackage.Literals.MODEL__STEPS,
				ExcelltsmetamodelFactory.eINSTANCE.createFilter()));

		newChildDescriptors.add(createChildParameter(ExcelltsmetamodelPackage.Literals.MODEL__STEPS,
				ExcelltsmetamodelFactory.eINSTANCE.createGenericStep()));

		newChildDescriptors.add(createChildParameter(ExcelltsmetamodelPackage.Literals.MODEL__STEPS,
				ExcelltsmetamodelFactory.eINSTANCE.createJoin()));

		newChildDescriptors.add(createChildParameter(ExcelltsmetamodelPackage.Literals.MODEL__STEPS,
				ExcelltsmetamodelFactory.eINSTANCE.createImport()));

		newChildDescriptors.add(createChildParameter(ExcelltsmetamodelPackage.Literals.MODEL__STEPS,
				ExcelltsmetamodelFactory.eINSTANCE.createLookup()));

		newChildDescriptors.add(createChildParameter(ExcelltsmetamodelPackage.Literals.MODEL__STEPS,
				ExcelltsmetamodelFactory.eINSTANCE.createRemoveDuplicates()));

		newChildDescriptors.add(createChildParameter(ExcelltsmetamodelPackage.Literals.MODEL__STEPS,
				ExcelltsmetamodelFactory.eINSTANCE.createConcat()));

		newChildDescriptors.add(createChildParameter(ExcelltsmetamodelPackage.Literals.MODEL__STEPS,
				ExcelltsmetamodelFactory.eINSTANCE.createSplit()));

		newChildDescriptors.add(createChildParameter(ExcelltsmetamodelPackage.Literals.MODEL__STEPS,
				ExcelltsmetamodelFactory.eINSTANCE.createExtract()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ExcelltsmetamodelEditPlugin.INSTANCE;
	}

}
