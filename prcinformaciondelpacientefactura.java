package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcinformaciondelpacientefactura extends GXProcedure
{
   public prcinformaciondelpacientefactura( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcinformaciondelpacientefactura.class ), "" );
   }

   public prcinformaciondelpacientefactura( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF> executeUdp( )
   {
      prcinformaciondelpacientefactura.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF>[] aP0 )
   {
      prcinformaciondelpacientefactura.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8PacienteA = (com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)new com.projectthani.SdtSDTInformacionDelPacienteFacturacionF(remoteHandle, context);
      AV8PacienteA.setgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento( "6" );
      AV8PacienteA.setgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfnrodocumento( "" );
      AV8PacienteA.setgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfrazonsocial( "" );
      AV8PacienteA.setgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfdireccion( "" );
      AV8PacienteA.setgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfemail( "" );
      AV9PacienteB.add(AV8PacienteA, 0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = prcinformaciondelpacientefactura.this.AV9PacienteB;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9PacienteB = new GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF>(com.projectthani.SdtSDTInformacionDelPacienteFacturacionF.class, "SDTInformacionDelPacienteFacturacionF", "ProjectThani", remoteHandle);
      AV8PacienteA = new com.projectthani.SdtSDTInformacionDelPacienteFacturacionF(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF>[] aP0 ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF> AV9PacienteB ;
   private com.projectthani.SdtSDTInformacionDelPacienteFacturacionF AV8PacienteA ;
}

