package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtSecUserRole implements Cloneable, java.io.Serializable
{
   public StructSdtSecUserRole( )
   {
      this( -1, new ModelContext( StructSdtSecUserRole.class ));
   }

   public StructSdtSecUserRole( int remoteHandle ,
                                ModelContext context )
   {
      gxTv_SdtSecUserRole_Secusername = "" ;
      gxTv_SdtSecUserRole_Secrolename = "" ;
      gxTv_SdtSecUserRole_Secroledescription = "" ;
      gxTv_SdtSecUserRole_Mode = "" ;
      gxTv_SdtSecUserRole_Secusername_Z = "" ;
      gxTv_SdtSecUserRole_Secrolename_Z = "" ;
      gxTv_SdtSecUserRole_Secroledescription_Z = "" ;
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

   public short getSecuserid( )
   {
      return gxTv_SdtSecUserRole_Secuserid ;
   }

   public void setSecuserid( short value )
   {
      gxTv_SdtSecUserRole_N = (byte)(0) ;
      gxTv_SdtSecUserRole_Secuserid = value ;
   }

   public short getSecroleid( )
   {
      return gxTv_SdtSecUserRole_Secroleid ;
   }

   public void setSecroleid( short value )
   {
      gxTv_SdtSecUserRole_N = (byte)(0) ;
      gxTv_SdtSecUserRole_Secroleid = value ;
   }

   public String getSecusername( )
   {
      return gxTv_SdtSecUserRole_Secusername ;
   }

   public void setSecusername( String value )
   {
      gxTv_SdtSecUserRole_N = (byte)(0) ;
      gxTv_SdtSecUserRole_Secusername = value ;
   }

   public String getSecrolename( )
   {
      return gxTv_SdtSecUserRole_Secrolename ;
   }

   public void setSecrolename( String value )
   {
      gxTv_SdtSecUserRole_N = (byte)(0) ;
      gxTv_SdtSecUserRole_Secrolename = value ;
   }

   public String getSecroledescription( )
   {
      return gxTv_SdtSecUserRole_Secroledescription ;
   }

   public void setSecroledescription( String value )
   {
      gxTv_SdtSecUserRole_N = (byte)(0) ;
      gxTv_SdtSecUserRole_Secroledescription = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtSecUserRole_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtSecUserRole_N = (byte)(0) ;
      gxTv_SdtSecUserRole_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtSecUserRole_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtSecUserRole_N = (byte)(0) ;
      gxTv_SdtSecUserRole_Initialized = value ;
   }

   public short getSecuserid_Z( )
   {
      return gxTv_SdtSecUserRole_Secuserid_Z ;
   }

   public void setSecuserid_Z( short value )
   {
      gxTv_SdtSecUserRole_N = (byte)(0) ;
      gxTv_SdtSecUserRole_Secuserid_Z = value ;
   }

   public short getSecroleid_Z( )
   {
      return gxTv_SdtSecUserRole_Secroleid_Z ;
   }

   public void setSecroleid_Z( short value )
   {
      gxTv_SdtSecUserRole_N = (byte)(0) ;
      gxTv_SdtSecUserRole_Secroleid_Z = value ;
   }

   public String getSecusername_Z( )
   {
      return gxTv_SdtSecUserRole_Secusername_Z ;
   }

   public void setSecusername_Z( String value )
   {
      gxTv_SdtSecUserRole_N = (byte)(0) ;
      gxTv_SdtSecUserRole_Secusername_Z = value ;
   }

   public String getSecrolename_Z( )
   {
      return gxTv_SdtSecUserRole_Secrolename_Z ;
   }

   public void setSecrolename_Z( String value )
   {
      gxTv_SdtSecUserRole_N = (byte)(0) ;
      gxTv_SdtSecUserRole_Secrolename_Z = value ;
   }

   public String getSecroledescription_Z( )
   {
      return gxTv_SdtSecUserRole_Secroledescription_Z ;
   }

   public void setSecroledescription_Z( String value )
   {
      gxTv_SdtSecUserRole_N = (byte)(0) ;
      gxTv_SdtSecUserRole_Secroledescription_Z = value ;
   }

   private byte gxTv_SdtSecUserRole_N ;
   protected short gxTv_SdtSecUserRole_Secuserid ;
   protected short gxTv_SdtSecUserRole_Secroleid ;
   protected short gxTv_SdtSecUserRole_Initialized ;
   protected short gxTv_SdtSecUserRole_Secuserid_Z ;
   protected short gxTv_SdtSecUserRole_Secroleid_Z ;
   protected String gxTv_SdtSecUserRole_Mode ;
   protected String gxTv_SdtSecUserRole_Secusername ;
   protected String gxTv_SdtSecUserRole_Secrolename ;
   protected String gxTv_SdtSecUserRole_Secroledescription ;
   protected String gxTv_SdtSecUserRole_Secusername_Z ;
   protected String gxTv_SdtSecUserRole_Secrolename_Z ;
   protected String gxTv_SdtSecUserRole_Secroledescription_Z ;
}

