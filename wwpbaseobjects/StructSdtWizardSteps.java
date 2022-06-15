package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "WizardSteps", namespace ="ProjectThani")
public final  class StructSdtWizardSteps implements Cloneable, java.io.Serializable
{
   public StructSdtWizardSteps( )
   {
      this( -1, new ModelContext( StructSdtWizardSteps.class ));
   }

   public StructSdtWizardSteps( int remoteHandle ,
                                ModelContext context )
   {
   }

   public  StructSdtWizardSteps( java.util.Vector<StructSdtWizardSteps_WizardStepsItem> value )
   {
      item = value;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   @javax.xml.bind.annotation.XmlElement(name="WizardStepsItem",namespace="ProjectThani")
   public java.util.Vector<StructSdtWizardSteps_WizardStepsItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWizardSteps_WizardStepsItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWizardSteps_WizardStepsItem> item = new java.util.Vector<>();
}

