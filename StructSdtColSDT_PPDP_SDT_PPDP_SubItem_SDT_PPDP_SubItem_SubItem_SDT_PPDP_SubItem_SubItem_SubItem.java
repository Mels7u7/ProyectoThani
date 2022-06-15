package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDT_PPDP.SDT_PPDP_SubItem.SDT_PPDP_SubItem_SubItem.SDT_PPDP_SubItem_SubItem_SubItem", namespace ="ProjectThani")
public final  class StructSdtColSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem implements Cloneable, java.io.Serializable
{
   public StructSdtColSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem( )
   {
      this( -1, new ModelContext( StructSdtColSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem.class ));
   }

   public StructSdtColSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem( int remoteHandle ,
                                                                                                           ModelContext context )
   {
   }

   public  StructSdtColSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem( java.util.Vector<StructSdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDT_PPDP.SDT_PPDP_SubItem.SDT_PPDP_SubItem_SubItem.SDT_PPDP_SubItem_SubItem_SubItem",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDT_PPDP_SDT_PPDP_SubItem_SDT_PPDP_SubItem_SubItem_SDT_PPDP_SubItem_SubItem_SubItem> item = new java.util.Vector<>();
}

