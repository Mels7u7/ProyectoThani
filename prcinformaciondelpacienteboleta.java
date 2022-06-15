package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcinformaciondelpacienteboleta extends GXProcedure
{
   public prcinformaciondelpacienteboleta( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcinformaciondelpacienteboleta.class ), "" );
   }

   public prcinformaciondelpacienteboleta( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB> executeUdp( int aP0 )
   {
      prcinformaciondelpacienteboleta.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB>[] aP1 )
   {
      prcinformaciondelpacienteboleta.this.AV10PacienteId = aP0;
      prcinformaciondelpacienteboleta.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P006K2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10PacienteId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A20PacienteId = P006K2_A20PacienteId[0] ;
         A105PacienteNombres = P006K2_A105PacienteNombres[0] ;
         A104PacienteApellidoMaterno = P006K2_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P006K2_A103PacienteApellidoPaterno[0] ;
         A214PacienteTipoDocumento = P006K2_A214PacienteTipoDocumento[0] ;
         A106PacienteNroDocumento = P006K2_A106PacienteNroDocumento[0] ;
         A215PacienteDireccion = P006K2_A215PacienteDireccion[0] ;
         A217PacienteCorreo = P006K2_A217PacienteCorreo[0] ;
         A218PacienteTelefono = P006K2_A218PacienteTelefono[0] ;
         AV8PacienteA = (com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)new com.projectthani.SdtSDTInformacionDelPacienteFacturacionB(remoteHandle, context);
         AV8PacienteA.setgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnombres( A105PacienteNombres );
         AV8PacienteA.setgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbapellidos( A103PacienteApellidoPaterno+" "+A104PacienteApellidoMaterno );
         AV8PacienteA.setgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento( A214PacienteTipoDocumento );
         AV8PacienteA.setgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnrodocumento( A106PacienteNroDocumento );
         AV8PacienteA.setgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbdireccion( A215PacienteDireccion );
         AV8PacienteA.setgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbemail( A217PacienteCorreo );
         AV8PacienteA.setgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtelefono( A218PacienteTelefono );
         AV9PacienteB.add(AV8PacienteA, 0);
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcinformaciondelpacienteboleta.this.AV9PacienteB;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9PacienteB = new GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB>(com.projectthani.SdtSDTInformacionDelPacienteFacturacionB.class, "SDTInformacionDelPacienteFacturacionB", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      P006K2_A20PacienteId = new int[1] ;
      P006K2_A105PacienteNombres = new String[] {""} ;
      P006K2_A104PacienteApellidoMaterno = new String[] {""} ;
      P006K2_A103PacienteApellidoPaterno = new String[] {""} ;
      P006K2_A214PacienteTipoDocumento = new String[] {""} ;
      P006K2_A106PacienteNroDocumento = new String[] {""} ;
      P006K2_A215PacienteDireccion = new String[] {""} ;
      P006K2_A217PacienteCorreo = new String[] {""} ;
      P006K2_A218PacienteTelefono = new String[] {""} ;
      A105PacienteNombres = "" ;
      A104PacienteApellidoMaterno = "" ;
      A103PacienteApellidoPaterno = "" ;
      A214PacienteTipoDocumento = "" ;
      A106PacienteNroDocumento = "" ;
      A215PacienteDireccion = "" ;
      A217PacienteCorreo = "" ;
      A218PacienteTelefono = "" ;
      AV8PacienteA = new com.projectthani.SdtSDTInformacionDelPacienteFacturacionB(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcinformaciondelpacienteboleta__default(),
         new Object[] {
             new Object[] {
            P006K2_A20PacienteId, P006K2_A105PacienteNombres, P006K2_A104PacienteApellidoMaterno, P006K2_A103PacienteApellidoPaterno, P006K2_A214PacienteTipoDocumento, P006K2_A106PacienteNroDocumento, P006K2_A215PacienteDireccion, P006K2_A217PacienteCorreo, P006K2_A218PacienteTelefono
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10PacienteId ;
   private int A20PacienteId ;
   private String scmdbuf ;
   private String A214PacienteTipoDocumento ;
   private String A218PacienteTelefono ;
   private String A105PacienteNombres ;
   private String A104PacienteApellidoMaterno ;
   private String A103PacienteApellidoPaterno ;
   private String A106PacienteNroDocumento ;
   private String A215PacienteDireccion ;
   private String A217PacienteCorreo ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB>[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P006K2_A20PacienteId ;
   private String[] P006K2_A105PacienteNombres ;
   private String[] P006K2_A104PacienteApellidoMaterno ;
   private String[] P006K2_A103PacienteApellidoPaterno ;
   private String[] P006K2_A214PacienteTipoDocumento ;
   private String[] P006K2_A106PacienteNroDocumento ;
   private String[] P006K2_A215PacienteDireccion ;
   private String[] P006K2_A217PacienteCorreo ;
   private String[] P006K2_A218PacienteTelefono ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB> AV9PacienteB ;
   private com.projectthani.SdtSDTInformacionDelPacienteFacturacionB AV8PacienteA ;
}

final  class prcinformaciondelpacienteboleta__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006K2", "SELECT [PacienteId], [PacienteNombres], [PacienteApellidoMaterno], [PacienteApellidoPaterno], [PacienteTipoDocumento], [PacienteNroDocumento], [PacienteDireccion], [PacienteCorreo], [PacienteTelefono] FROM [Paciente] WHERE [PacienteId] = ? ORDER BY [PacienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

