package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "DVHorizontalMenuData", namespace ="ProjectThani")
public final  class StructSdtDVHorizontalMenuData implements Cloneable, java.io.Serializable
{
   public StructSdtDVHorizontalMenuData( )
   {
      this( -1, new ModelContext( StructSdtDVHorizontalMenuData.class ));
   }

   public StructSdtDVHorizontalMenuData( int remoteHandle ,
                                         ModelContext context )
   {
   }

   public  StructSdtDVHorizontalMenuData( java.util.Vector<StructSdtDVHorizontalMenuData_DVHorizontalMenuItem> value )
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

   @javax.xml.bind.annotation.XmlElement(name="DVHorizontalMenuItem",namespace="ProjectThani")
   public java.util.Vector<StructSdtDVHorizontalMenuData_DVHorizontalMenuItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtDVHorizontalMenuData_DVHorizontalMenuItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtDVHorizontalMenuData_DVHorizontalMenuItem> item = new java.util.Vector<>();
}

