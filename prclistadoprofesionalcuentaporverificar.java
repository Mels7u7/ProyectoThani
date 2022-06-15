package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prclistadoprofesionalcuentaporverificar extends GXProcedure
{
   public prclistadoprofesionalcuentaporverificar( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prclistadoprofesionalcuentaporverificar.class ), "" );
   }

   public prclistadoprofesionalcuentaporverificar( int remoteHandle ,
                                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTCuentaPorVerificarProfesional> executeUdp( )
   {
      prclistadoprofesionalcuentaporverificar.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTCuentaPorVerificarProfesional>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.projectthani.SdtSDTCuentaPorVerificarProfesional>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.projectthani.SdtSDTCuentaPorVerificarProfesional>[] aP0 )
   {
      prclistadoprofesionalcuentaporverificar.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P007N2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A197ProfesionalEstadoCuenta = P007N2_A197ProfesionalEstadoCuenta[0] ;
         A198ProfesionalEstado = P007N2_A198ProfesionalEstado[0] ;
         A31ProfesionalId = P007N2_A31ProfesionalId[0] ;
         A173ProfesionalTipoDocumento = P007N2_A173ProfesionalTipoDocumento[0] ;
         A174ProfesionalNroDocumento = P007N2_A174ProfesionalNroDocumento[0] ;
         A85ProfesionalApellidoPaterno = P007N2_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P007N2_A86ProfesionalApellidoMaterno[0] ;
         A84ProfesionalNombres = P007N2_A84ProfesionalNombres[0] ;
         A88ProfesionalCOP = P007N2_A88ProfesionalCOP[0] ;
         A177ProfesionalSexo = P007N2_A177ProfesionalSexo[0] ;
         A194ProfesionalTelefono = P007N2_A194ProfesionalTelefono[0] ;
         A179ProfesionalCorreo = P007N2_A179ProfesionalCorreo[0] ;
         A195ProfesionalFechaRegistro = P007N2_A195ProfesionalFechaRegistro[0] ;
         AV9ProfesionalList = (com.projectthani.SdtSDTCuentaPorVerificarProfesional)new com.projectthani.SdtSDTCuentaPorVerificarProfesional(remoteHandle, context);
         AV9ProfesionalList.setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalid( A31ProfesionalId );
         AV9ProfesionalList.setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltipodocumento( A173ProfesionalTipoDocumento );
         AV9ProfesionalList.setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnrodocumento( A174ProfesionalNroDocumento );
         AV9ProfesionalList.setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidopaterno( A85ProfesionalApellidoPaterno );
         AV9ProfesionalList.setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalapellidomaterno( A86ProfesionalApellidoMaterno );
         AV9ProfesionalList.setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalnombres( A84ProfesionalNombres );
         AV9ProfesionalList.setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcop( A88ProfesionalCOP );
         AV9ProfesionalList.setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalsexo( A177ProfesionalSexo );
         AV9ProfesionalList.setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionaltelefono( A194ProfesionalTelefono );
         AV9ProfesionalList.setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalcorreo( A179ProfesionalCorreo );
         AV9ProfesionalList.setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalfecharegistro( A195ProfesionalFechaRegistro );
         AV9ProfesionalList.setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestadocuenta( A197ProfesionalEstadoCuenta );
         AV9ProfesionalList.setgxTv_SdtSDTCuentaPorVerificarProfesional_Profesionalestado( A198ProfesionalEstado );
         AV8ListCuentaPorVerificar.add(AV9ProfesionalList, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = prclistadoprofesionalcuentaporverificar.this.AV8ListCuentaPorVerificar;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8ListCuentaPorVerificar = new GXBaseCollection<com.projectthani.SdtSDTCuentaPorVerificarProfesional>(com.projectthani.SdtSDTCuentaPorVerificarProfesional.class, "SDTCuentaPorVerificarProfesional", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      P007N2_A197ProfesionalEstadoCuenta = new String[] {""} ;
      P007N2_A198ProfesionalEstado = new String[] {""} ;
      P007N2_A31ProfesionalId = new int[1] ;
      P007N2_A173ProfesionalTipoDocumento = new String[] {""} ;
      P007N2_A174ProfesionalNroDocumento = new String[] {""} ;
      P007N2_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P007N2_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P007N2_A84ProfesionalNombres = new String[] {""} ;
      P007N2_A88ProfesionalCOP = new String[] {""} ;
      P007N2_A177ProfesionalSexo = new String[] {""} ;
      P007N2_A194ProfesionalTelefono = new String[] {""} ;
      P007N2_A179ProfesionalCorreo = new String[] {""} ;
      P007N2_A195ProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      A197ProfesionalEstadoCuenta = "" ;
      A198ProfesionalEstado = "" ;
      A173ProfesionalTipoDocumento = "" ;
      A174ProfesionalNroDocumento = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      A84ProfesionalNombres = "" ;
      A88ProfesionalCOP = "" ;
      A177ProfesionalSexo = "" ;
      A194ProfesionalTelefono = "" ;
      A179ProfesionalCorreo = "" ;
      A195ProfesionalFechaRegistro = GXutil.nullDate() ;
      AV9ProfesionalList = new com.projectthani.SdtSDTCuentaPorVerificarProfesional(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prclistadoprofesionalcuentaporverificar__default(),
         new Object[] {
             new Object[] {
            P007N2_A197ProfesionalEstadoCuenta, P007N2_A198ProfesionalEstado, P007N2_A31ProfesionalId, P007N2_A173ProfesionalTipoDocumento, P007N2_A174ProfesionalNroDocumento, P007N2_A85ProfesionalApellidoPaterno, P007N2_A86ProfesionalApellidoMaterno, P007N2_A84ProfesionalNombres, P007N2_A88ProfesionalCOP, P007N2_A177ProfesionalSexo,
            P007N2_A194ProfesionalTelefono, P007N2_A179ProfesionalCorreo, P007N2_A195ProfesionalFechaRegistro
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int A31ProfesionalId ;
   private String scmdbuf ;
   private String A197ProfesionalEstadoCuenta ;
   private String A198ProfesionalEstado ;
   private String A173ProfesionalTipoDocumento ;
   private String A177ProfesionalSexo ;
   private String A194ProfesionalTelefono ;
   private java.util.Date A195ProfesionalFechaRegistro ;
   private String A174ProfesionalNroDocumento ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String A84ProfesionalNombres ;
   private String A88ProfesionalCOP ;
   private String A179ProfesionalCorreo ;
   private GXBaseCollection<com.projectthani.SdtSDTCuentaPorVerificarProfesional>[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P007N2_A197ProfesionalEstadoCuenta ;
   private String[] P007N2_A198ProfesionalEstado ;
   private int[] P007N2_A31ProfesionalId ;
   private String[] P007N2_A173ProfesionalTipoDocumento ;
   private String[] P007N2_A174ProfesionalNroDocumento ;
   private String[] P007N2_A85ProfesionalApellidoPaterno ;
   private String[] P007N2_A86ProfesionalApellidoMaterno ;
   private String[] P007N2_A84ProfesionalNombres ;
   private String[] P007N2_A88ProfesionalCOP ;
   private String[] P007N2_A177ProfesionalSexo ;
   private String[] P007N2_A194ProfesionalTelefono ;
   private String[] P007N2_A179ProfesionalCorreo ;
   private java.util.Date[] P007N2_A195ProfesionalFechaRegistro ;
   private GXBaseCollection<com.projectthani.SdtSDTCuentaPorVerificarProfesional> AV8ListCuentaPorVerificar ;
   private com.projectthani.SdtSDTCuentaPorVerificarProfesional AV9ProfesionalList ;
}

final  class prclistadoprofesionalcuentaporverificar__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007N2", "SELECT [ProfesionalEstadoCuenta], [ProfesionalEstado], [ProfesionalId], [ProfesionalTipoDocumento], [ProfesionalNroDocumento], [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno], [ProfesionalNombres], [ProfesionalCOP], [ProfesionalSexo], [ProfesionalTelefono], [ProfesionalCorreo], [ProfesionalFechaRegistro] FROM [Profesional] WHERE ([ProfesionalEstado] = 'P') AND ([ProfesionalEstadoCuenta] = 'CV') ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 2);
               ((String[]) buf[1])[0] = rslt.getString(2, 2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 1);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDate(13);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

