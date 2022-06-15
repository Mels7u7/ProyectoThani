package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "DVB_SDTDropDownOptionsTitleSettingsIcons", namespace ="")
public final  class StructSdtDVB_SDTDropDownOptionsTitleSettingsIcons implements Cloneable, java.io.Serializable
{
   public StructSdtDVB_SDTDropDownOptionsTitleSettingsIcons( )
   {
      this( -1, new ModelContext( StructSdtDVB_SDTDropDownOptionsTitleSettingsIcons.class ));
   }

   public StructSdtDVB_SDTDropDownOptionsTitleSettingsIcons( int remoteHandle ,
                                                             ModelContext context )
   {
   }

   public  StructSdtDVB_SDTDropDownOptionsTitleSettingsIcons( java.util.Vector<StructSdtDVB_SDTDropDownOptionsTitleSettingsIcons> value )
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

   @javax.xml.bind.annotation.XmlElement(name="TitleSettingsIcons",namespace="")
   public java.util.Vector<StructSdtDVB_SDTDropDownOptionsTitleSettingsIcons> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtDVB_SDTDropDownOptionsTitleSettingsIcons> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtDVB_SDTDropDownOptionsTitleSettingsIcons> item = new java.util.Vector<>();
}

