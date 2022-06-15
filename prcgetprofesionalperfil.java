package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgetprofesionalperfil extends GXProcedure
{
   public prcgetprofesionalperfil( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgetprofesionalperfil.class ), "" );
   }

   public prcgetprofesionalperfil( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTProfesionalPerfil> executeUdp( int aP0 )
   {
      prcgetprofesionalperfil.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTProfesionalPerfil>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        GXBaseCollection<com.projectthani.SdtSDTProfesionalPerfil>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             GXBaseCollection<com.projectthani.SdtSDTProfesionalPerfil>[] aP1 )
   {
      prcgetprofesionalperfil.this.AV13ProfesionalId = aP0;
      prcgetprofesionalperfil.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P005L2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13ProfesionalId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31ProfesionalId = P005L2_A31ProfesionalId[0] ;
         A40000ProfesionalFoto_GXI = P005L2_A40000ProfesionalFoto_GXI[0] ;
         A183ProfesionalDireccion = P005L2_A183ProfesionalDireccion[0] ;
         A189ProfesionalFoto = P005L2_A189ProfesionalFoto[0] ;
         A191ProfesionalFacebook = P005L2_A191ProfesionalFacebook[0] ;
         A192ProfesionalInstagram = P005L2_A192ProfesionalInstagram[0] ;
         A190ProfesionalTwitter = P005L2_A190ProfesionalTwitter[0] ;
         A193ProfesionalLinkedin = P005L2_A193ProfesionalLinkedin[0] ;
         A178ProfesionalDescripcion = P005L2_A178ProfesionalDescripcion[0] ;
         A84ProfesionalNombres = P005L2_A84ProfesionalNombres[0] ;
         A86ProfesionalApellidoMaterno = P005L2_A86ProfesionalApellidoMaterno[0] ;
         A85ProfesionalApellidoPaterno = P005L2_A85ProfesionalApellidoPaterno[0] ;
         A175ProfesionalNombreCompleto2 = A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno + ", " + A84ProfesionalNombres ;
         AV11Profesional = (com.projectthani.SdtSDTProfesionalPerfil)new com.projectthani.SdtSDTProfesionalPerfil(remoteHandle, context);
         AV11Profesional.setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilprofesionalid( (short)(AV13ProfesionalId) );
         AV11Profesional.setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilnombresapellidos( A175ProfesionalNombreCompleto2 );
         GXt_char1 = "" ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetespecialidadbyprofesional(remoteHandle, context).execute( AV13ProfesionalId, GXv_char2) ;
         prcgetprofesionalperfil.this.GXt_char1 = GXv_char2[0] ;
         AV11Profesional.setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilespecialidades( GXt_char1 );
         GXv_int3[0] = (byte)(AV14Rating) ;
         new com.projectthani.prccalcularratingporprofesional(remoteHandle, context).execute( AV13ProfesionalId, GXv_int3) ;
         prcgetprofesionalperfil.this.AV14Rating = GXv_int3[0] ;
         AV11Profesional.setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilcalificacion( AV14Rating );
         AV11Profesional.setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfildireccion( A183ProfesionalDireccion );
         AV11Profesional.setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfotografia( A189ProfesionalFoto );
         AV11Profesional.setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfotografia_gxi( A40000ProfesionalFoto_GXI );
         AV11Profesional.setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfacebook( A191ProfesionalFacebook );
         AV11Profesional.setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilinstagram( A192ProfesionalInstagram );
         AV11Profesional.setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfiltwiter( A190ProfesionalTwitter );
         AV11Profesional.setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfillinkedin( A193ProfesionalLinkedin );
         AV11Profesional.setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilotros( "" );
         AV11Profesional.setgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfildescripcion( A178ProfesionalDescripcion );
         AV12Profesionales.add(AV11Profesional, 0);
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcgetprofesionalperfil.this.AV12Profesionales;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12Profesionales = new GXBaseCollection<com.projectthani.SdtSDTProfesionalPerfil>(com.projectthani.SdtSDTProfesionalPerfil.class, "SDTProfesionalPerfil", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      P005L2_A31ProfesionalId = new int[1] ;
      P005L2_A40000ProfesionalFoto_GXI = new String[] {""} ;
      P005L2_A183ProfesionalDireccion = new String[] {""} ;
      P005L2_A189ProfesionalFoto = new String[] {""} ;
      P005L2_A191ProfesionalFacebook = new String[] {""} ;
      P005L2_A192ProfesionalInstagram = new String[] {""} ;
      P005L2_A190ProfesionalTwitter = new String[] {""} ;
      P005L2_A193ProfesionalLinkedin = new String[] {""} ;
      P005L2_A178ProfesionalDescripcion = new String[] {""} ;
      P005L2_A84ProfesionalNombres = new String[] {""} ;
      P005L2_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P005L2_A85ProfesionalApellidoPaterno = new String[] {""} ;
      A40000ProfesionalFoto_GXI = "" ;
      A183ProfesionalDireccion = "" ;
      A189ProfesionalFoto = "" ;
      A191ProfesionalFacebook = "" ;
      A192ProfesionalInstagram = "" ;
      A190ProfesionalTwitter = "" ;
      A193ProfesionalLinkedin = "" ;
      A178ProfesionalDescripcion = "" ;
      A84ProfesionalNombres = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A175ProfesionalNombreCompleto2 = "" ;
      AV11Profesional = new com.projectthani.SdtSDTProfesionalPerfil(remoteHandle, context);
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      GXv_int3 = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcgetprofesionalperfil__default(),
         new Object[] {
             new Object[] {
            P005L2_A31ProfesionalId, P005L2_A40000ProfesionalFoto_GXI, P005L2_A183ProfesionalDireccion, P005L2_A189ProfesionalFoto, P005L2_A191ProfesionalFacebook, P005L2_A192ProfesionalInstagram, P005L2_A190ProfesionalTwitter, P005L2_A193ProfesionalLinkedin, P005L2_A178ProfesionalDescripcion, P005L2_A84ProfesionalNombres,
            P005L2_A86ProfesionalApellidoMaterno, P005L2_A85ProfesionalApellidoPaterno
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte GXv_int3[] ;
   private short AV14Rating ;
   private short Gx_err ;
   private int AV13ProfesionalId ;
   private int A31ProfesionalId ;
   private String scmdbuf ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String A40000ProfesionalFoto_GXI ;
   private String A183ProfesionalDireccion ;
   private String A191ProfesionalFacebook ;
   private String A192ProfesionalInstagram ;
   private String A190ProfesionalTwitter ;
   private String A193ProfesionalLinkedin ;
   private String A178ProfesionalDescripcion ;
   private String A84ProfesionalNombres ;
   private String A86ProfesionalApellidoMaterno ;
   private String A85ProfesionalApellidoPaterno ;
   private String A175ProfesionalNombreCompleto2 ;
   private String A189ProfesionalFoto ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalPerfil>[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P005L2_A31ProfesionalId ;
   private String[] P005L2_A40000ProfesionalFoto_GXI ;
   private String[] P005L2_A183ProfesionalDireccion ;
   private String[] P005L2_A189ProfesionalFoto ;
   private String[] P005L2_A191ProfesionalFacebook ;
   private String[] P005L2_A192ProfesionalInstagram ;
   private String[] P005L2_A190ProfesionalTwitter ;
   private String[] P005L2_A193ProfesionalLinkedin ;
   private String[] P005L2_A178ProfesionalDescripcion ;
   private String[] P005L2_A84ProfesionalNombres ;
   private String[] P005L2_A86ProfesionalApellidoMaterno ;
   private String[] P005L2_A85ProfesionalApellidoPaterno ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalPerfil> AV12Profesionales ;
   private com.projectthani.SdtSDTProfesionalPerfil AV11Profesional ;
}

final  class prcgetprofesionalperfil__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P005L2", "SELECT [ProfesionalId], [ProfesionalFoto_GXI], [ProfesionalDireccion], [ProfesionalFoto], [ProfesionalFacebook], [ProfesionalInstagram], [ProfesionalTwitter], [ProfesionalLinkedin], [ProfesionalDescripcion], [ProfesionalNombres], [ProfesionalApellidoMaterno], [ProfesionalApellidoPaterno] FROM [Profesional] WHERE [ProfesionalId] = ? ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getMultimediaUri(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getMultimediaFile(4, rslt.getVarchar(2));
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
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

