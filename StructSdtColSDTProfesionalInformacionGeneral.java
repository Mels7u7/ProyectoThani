package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTProfesionalInformacionGeneral", namespace ="ProjectThani")
public final  class StructSdtColSDTProfesionalInformacionGeneral implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTProfesionalInformacionGeneral( )
   {
      this( -1, new ModelContext( StructSdtColSDTProfesionalInformacionGeneral.class ));
   }

   public StructSdtColSDTProfesionalInformacionGeneral( int remoteHandle ,
                                                        ModelContext context )
   {
   }

   public  StructSdtColSDTProfesionalInformacionGeneral( java.util.Vector<StructSdtSDTProfesionalInformacionGeneral> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTProfesionalInformacionGeneral",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTProfesionalInformacionGeneral> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTProfesionalInformacionGeneral> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTProfesionalInformacionGeneral> item = new java.util.Vector<>();
}

