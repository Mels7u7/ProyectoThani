package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTDoctorReservarCita", namespace ="ProjectThani")
public final  class StructSdtColSDTDoctorReservarCita implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTDoctorReservarCita( )
   {
      this( -1, new ModelContext( StructSdtColSDTDoctorReservarCita.class ));
   }

   public StructSdtColSDTDoctorReservarCita( int remoteHandle ,
                                             ModelContext context )
   {
   }

   public  StructSdtColSDTDoctorReservarCita( java.util.Vector<StructSdtSDTDoctorReservarCita> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTDoctorReservarCita",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTDoctorReservarCita> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTDoctorReservarCita> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTDoctorReservarCita> item = new java.util.Vector<>();
}

