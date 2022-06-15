package com.projectthani ;
import com.genexus.*;

public final  class StructSdtLogAccesos implements Cloneable, java.io.Serializable
{
   public StructSdtLogAccesos( )
   {
      this( -1, new ModelContext( StructSdtLogAccesos.class ));
   }

   public StructSdtLogAccesos( int remoteHandle ,
                               ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtLogAccesos_Secusername = "" ;
      gxTv_SdtLogAccesos_Secroledescription = "" ;
      gxTv_SdtLogAccesos_Logaccesosfullname = "" ;
      gxTv_SdtLogAccesos_Logaccesostipo = "" ;
      gxTv_SdtLogAccesos_Logaccesosfecha = cal.getTime() ;
      gxTv_SdtLogAccesos_Mode = "" ;
      gxTv_SdtLogAccesos_Secusername_Z = "" ;
      gxTv_SdtLogAccesos_Secroledescription_Z = "" ;
      gxTv_SdtLogAccesos_Logaccesosfullname_Z = "" ;
      gxTv_SdtLogAccesos_Logaccesostipo_Z = "" ;
      gxTv_SdtLogAccesos_Logaccesosfecha_Z = cal.getTime() ;
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

   public short getLogaccesosid( )
   {
      return gxTv_SdtLogAccesos_Logaccesosid ;
   }

   public void setLogaccesosid( short value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      gxTv_SdtLogAccesos_Logaccesosid = value ;
   }

   public short getSecuserid( )
   {
      return gxTv_SdtLogAccesos_Secuserid ;
   }

   public void setSecuserid( short value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      gxTv_SdtLogAccesos_Secuserid = value ;
   }

   public String getSecusername( )
   {
      return gxTv_SdtLogAccesos_Secusername ;
   }

   public void setSecusername( String value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      gxTv_SdtLogAccesos_Secusername = value ;
   }

   public short getSecroleid( )
   {
      return gxTv_SdtLogAccesos_Secroleid ;
   }

   public void setSecroleid( short value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      gxTv_SdtLogAccesos_Secroleid = value ;
   }

   public String getSecroledescription( )
   {
      return gxTv_SdtLogAccesos_Secroledescription ;
   }

   public void setSecroledescription( String value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      gxTv_SdtLogAccesos_Secroledescription = value ;
   }

   public String getLogaccesosfullname( )
   {
      return gxTv_SdtLogAccesos_Logaccesosfullname ;
   }

   public void setLogaccesosfullname( String value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      gxTv_SdtLogAccesos_Logaccesosfullname = value ;
   }

   public String getLogaccesostipo( )
   {
      return gxTv_SdtLogAccesos_Logaccesostipo ;
   }

   public void setLogaccesostipo( String value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      gxTv_SdtLogAccesos_Logaccesostipo = value ;
   }

   public java.util.Date getLogaccesosfecha( )
   {
      return gxTv_SdtLogAccesos_Logaccesosfecha ;
   }

   public void setLogaccesosfecha( java.util.Date value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      gxTv_SdtLogAccesos_Logaccesosfecha = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtLogAccesos_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      gxTv_SdtLogAccesos_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtLogAccesos_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      gxTv_SdtLogAccesos_Initialized = value ;
   }

   public short getLogaccesosid_Z( )
   {
      return gxTv_SdtLogAccesos_Logaccesosid_Z ;
   }

   public void setLogaccesosid_Z( short value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      gxTv_SdtLogAccesos_Logaccesosid_Z = value ;
   }

   public short getSecuserid_Z( )
   {
      return gxTv_SdtLogAccesos_Secuserid_Z ;
   }

   public void setSecuserid_Z( short value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      gxTv_SdtLogAccesos_Secuserid_Z = value ;
   }

   public String getSecusername_Z( )
   {
      return gxTv_SdtLogAccesos_Secusername_Z ;
   }

   public void setSecusername_Z( String value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      gxTv_SdtLogAccesos_Secusername_Z = value ;
   }

   public short getSecroleid_Z( )
   {
      return gxTv_SdtLogAccesos_Secroleid_Z ;
   }

   public void setSecroleid_Z( short value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      gxTv_SdtLogAccesos_Secroleid_Z = value ;
   }

   public String getSecroledescription_Z( )
   {
      return gxTv_SdtLogAccesos_Secroledescription_Z ;
   }

   public void setSecroledescription_Z( String value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      gxTv_SdtLogAccesos_Secroledescription_Z = value ;
   }

   public String getLogaccesosfullname_Z( )
   {
      return gxTv_SdtLogAccesos_Logaccesosfullname_Z ;
   }

   public void setLogaccesosfullname_Z( String value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      gxTv_SdtLogAccesos_Logaccesosfullname_Z = value ;
   }

   public String getLogaccesostipo_Z( )
   {
      return gxTv_SdtLogAccesos_Logaccesostipo_Z ;
   }

   public void setLogaccesostipo_Z( String value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      gxTv_SdtLogAccesos_Logaccesostipo_Z = value ;
   }

   public java.util.Date getLogaccesosfecha_Z( )
   {
      return gxTv_SdtLogAccesos_Logaccesosfecha_Z ;
   }

   public void setLogaccesosfecha_Z( java.util.Date value )
   {
      gxTv_SdtLogAccesos_N = (byte)(0) ;
      gxTv_SdtLogAccesos_Logaccesosfecha_Z = value ;
   }

   private byte gxTv_SdtLogAccesos_N ;
   protected short gxTv_SdtLogAccesos_Logaccesosid ;
   protected short gxTv_SdtLogAccesos_Secuserid ;
   protected short gxTv_SdtLogAccesos_Secroleid ;
   protected short gxTv_SdtLogAccesos_Initialized ;
   protected short gxTv_SdtLogAccesos_Logaccesosid_Z ;
   protected short gxTv_SdtLogAccesos_Secuserid_Z ;
   protected short gxTv_SdtLogAccesos_Secroleid_Z ;
   protected String gxTv_SdtLogAccesos_Logaccesostipo ;
   protected String gxTv_SdtLogAccesos_Mode ;
   protected String gxTv_SdtLogAccesos_Logaccesostipo_Z ;
   protected String gxTv_SdtLogAccesos_Secusername ;
   protected String gxTv_SdtLogAccesos_Secroledescription ;
   protected String gxTv_SdtLogAccesos_Logaccesosfullname ;
   protected String gxTv_SdtLogAccesos_Secusername_Z ;
   protected String gxTv_SdtLogAccesos_Secroledescription_Z ;
   protected String gxTv_SdtLogAccesos_Logaccesosfullname_Z ;
   protected java.util.Date gxTv_SdtLogAccesos_Logaccesosfecha ;
   protected java.util.Date gxTv_SdtLogAccesos_Logaccesosfecha_Z ;
}

