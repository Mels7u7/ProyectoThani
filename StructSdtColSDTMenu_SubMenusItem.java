package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTMenu.SubMenusItem", namespace ="ProjectThani")
public final  class StructSdtColSDTMenu_SubMenusItem implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTMenu_SubMenusItem( )
   {
      this( -1, new ModelContext( StructSdtColSDTMenu_SubMenusItem.class ));
   }

   public StructSdtColSDTMenu_SubMenusItem( int remoteHandle ,
                                            ModelContext context )
   {
   }

   public  StructSdtColSDTMenu_SubMenusItem( java.util.Vector<StructSdtSDTMenu_SubMenusItem> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTMenu.SubMenusItem",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTMenu_SubMenusItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTMenu_SubMenusItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTMenu_SubMenusItem> item = new java.util.Vector<>();
}

