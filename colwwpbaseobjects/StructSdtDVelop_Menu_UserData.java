package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "DVelop_Menu_UserData", namespace ="ProjectThani")
public final  class StructSdtDVelop_Menu_UserData implements Cloneable, java.io.Serializable
{
   public StructSdtDVelop_Menu_UserData( )
   {
      this( -1, new ModelContext( StructSdtDVelop_Menu_UserData.class ));
   }

   public StructSdtDVelop_Menu_UserData( int remoteHandle ,
                                         ModelContext context )
   {
   }

   public  StructSdtDVelop_Menu_UserData( java.util.Vector<StructSdtDVelop_Menu_UserData> value )
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

   @javax.xml.bind.annotation.XmlElement(name="DVelop_Menu_UserData",namespace="ProjectThani")
   public java.util.Vector<StructSdtDVelop_Menu_UserData> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtDVelop_Menu_UserData> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtDVelop_Menu_UserData> item = new java.util.Vector<>();
}

