package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTListadoPacienteFamiliarComboBox", namespace ="ProjectThani")
public final  class StructSdtColSDTListadoPacienteFamiliarComboBox implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTListadoPacienteFamiliarComboBox( )
   {
      this( -1, new ModelContext( StructSdtColSDTListadoPacienteFamiliarComboBox.class ));
   }

   public StructSdtColSDTListadoPacienteFamiliarComboBox( int remoteHandle ,
                                                          ModelContext context )
   {
   }

   public  StructSdtColSDTListadoPacienteFamiliarComboBox( java.util.Vector<StructSdtSDTListadoPacienteFamiliarComboBox> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTListadoPacienteFamiliarComboBox",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTListadoPacienteFamiliarComboBox> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTListadoPacienteFamiliarComboBox> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTListadoPacienteFamiliarComboBox> item = new java.util.Vector<>();
}

