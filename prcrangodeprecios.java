package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcrangodeprecios extends GXProcedure
{
   public prcrangodeprecios( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcrangodeprecios.class ), "" );
   }

   public prcrangodeprecios( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTRangoPrecios> executeUdp( )
   {
      prcrangodeprecios.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTRangoPrecios>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.projectthani.SdtSDTRangoPrecios>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.projectthani.SdtSDTRangoPrecios>[] aP0 )
   {
      prcrangodeprecios.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8Precio = (com.projectthani.SdtSDTRangoPrecios)new com.projectthani.SdtSDTRangoPrecios(remoteHandle, context);
      AV8Precio.setgxTv_SdtSDTRangoPrecios_Idprecio( (short)(1) );
      AV8Precio.setgxTv_SdtSDTRangoPrecios_Descripcion( "01 -50 " );
      AV8Precio.setgxTv_SdtSDTRangoPrecios_Valora( DecimalUtil.stringToDec("1.00") );
      AV8Precio.setgxTv_SdtSDTRangoPrecios_Valorb( DecimalUtil.stringToDec("50.00") );
      AV8Precio.setgxTv_SdtSDTRangoPrecios_Estado( false );
      AV9Precios.add(AV8Precio, 0);
      AV8Precio = (com.projectthani.SdtSDTRangoPrecios)new com.projectthani.SdtSDTRangoPrecios(remoteHandle, context);
      AV8Precio.setgxTv_SdtSDTRangoPrecios_Idprecio( (short)(2) );
      AV8Precio.setgxTv_SdtSDTRangoPrecios_Descripcion( "51 - 100" );
      AV8Precio.setgxTv_SdtSDTRangoPrecios_Valora( DecimalUtil.stringToDec("51.00") );
      AV8Precio.setgxTv_SdtSDTRangoPrecios_Valorb( DecimalUtil.stringToDec("100.00") );
      AV8Precio.setgxTv_SdtSDTRangoPrecios_Estado( false );
      AV9Precios.add(AV8Precio, 0);
      AV8Precio = (com.projectthani.SdtSDTRangoPrecios)new com.projectthani.SdtSDTRangoPrecios(remoteHandle, context);
      AV8Precio.setgxTv_SdtSDTRangoPrecios_Idprecio( (short)(3) );
      AV8Precio.setgxTv_SdtSDTRangoPrecios_Descripcion( "101 - 150" );
      AV8Precio.setgxTv_SdtSDTRangoPrecios_Valora( DecimalUtil.stringToDec("101.00") );
      AV8Precio.setgxTv_SdtSDTRangoPrecios_Valorb( DecimalUtil.stringToDec("150.00") );
      AV8Precio.setgxTv_SdtSDTRangoPrecios_Estado( false );
      AV9Precios.add(AV8Precio, 0);
      AV8Precio = (com.projectthani.SdtSDTRangoPrecios)new com.projectthani.SdtSDTRangoPrecios(remoteHandle, context);
      AV8Precio.setgxTv_SdtSDTRangoPrecios_Idprecio( (short)(4) );
      AV8Precio.setgxTv_SdtSDTRangoPrecios_Descripcion( "151 - 200" );
      AV8Precio.setgxTv_SdtSDTRangoPrecios_Valora( DecimalUtil.stringToDec("151.00") );
      AV8Precio.setgxTv_SdtSDTRangoPrecios_Valorb( DecimalUtil.stringToDec("200.00") );
      AV8Precio.setgxTv_SdtSDTRangoPrecios_Estado( false );
      AV9Precios.add(AV8Precio, 0);
      AV8Precio = (com.projectthani.SdtSDTRangoPrecios)new com.projectthani.SdtSDTRangoPrecios(remoteHandle, context);
      AV8Precio.setgxTv_SdtSDTRangoPrecios_Idprecio( (short)(5) );
      AV8Precio.setgxTv_SdtSDTRangoPrecios_Descripcion( "201 a mas " );
      AV8Precio.setgxTv_SdtSDTRangoPrecios_Valora( DecimalUtil.stringToDec("201.00") );
      AV8Precio.setgxTv_SdtSDTRangoPrecios_Valorb( DecimalUtil.stringToDec("201.00") );
      AV8Precio.setgxTv_SdtSDTRangoPrecios_Estado( false );
      AV9Precios.add(AV8Precio, 0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = prcrangodeprecios.this.AV9Precios;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9Precios = new GXBaseCollection<com.projectthani.SdtSDTRangoPrecios>(com.projectthani.SdtSDTRangoPrecios.class, "SDTRangoPrecios", "ProjectThani", remoteHandle);
      AV8Precio = new com.projectthani.SdtSDTRangoPrecios(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private GXBaseCollection<com.projectthani.SdtSDTRangoPrecios>[] aP0 ;
   private GXBaseCollection<com.projectthani.SdtSDTRangoPrecios> AV9Precios ;
   private com.projectthani.SdtSDTRangoPrecios AV8Precio ;
}

