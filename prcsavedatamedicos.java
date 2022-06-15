package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcsavedatamedicos extends GXProcedure
{
   public prcsavedatamedicos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcsavedatamedicos.class ), "" );
   }

   public prcsavedatamedicos( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( GXBaseCollection<com.projectthani.SdtSDTImportMedico> aP0 ,
                            GXBaseCollection<com.projectthani.SdtSDTImportMedicoError>[] aP1 ,
                            short[] aP2 )
   {
      prcsavedatamedicos.this.aP3 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( GXBaseCollection<com.projectthani.SdtSDTImportMedico> aP0 ,
                        GXBaseCollection<com.projectthani.SdtSDTImportMedicoError>[] aP1 ,
                        short[] aP2 ,
                        short[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( GXBaseCollection<com.projectthani.SdtSDTImportMedico> aP0 ,
                             GXBaseCollection<com.projectthani.SdtSDTImportMedicoError>[] aP1 ,
                             short[] aP2 ,
                             short[] aP3 )
   {
      prcsavedatamedicos.this.AV13SDTImportMedicoList = aP0;
      prcsavedatamedicos.this.aP1 = aP1;
      prcsavedatamedicos.this.aP2 = aP2;
      prcsavedatamedicos.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8isExisteProfesional = false ;
      AV11RegistroNuevo = (short)(0) ;
      AV10RegistroExiste = (short)(0) ;
      AV23GXV1 = 1 ;
      while ( AV23GXV1 <= AV13SDTImportMedicoList.size() )
      {
         AV12SDTImportMedicoItem = (com.projectthani.SdtSDTImportMedico)((com.projectthani.SdtSDTImportMedico)AV13SDTImportMedicoList.elementAt(-1+AV23GXV1));
         GXv_boolean1[0] = AV8isExisteProfesional ;
         GXv_boolean2[0] = AV9isExisteUser ;
         new com.projectthani.prcvalidarexisteuserandprofesional(remoteHandle, context).execute( GXutil.trim( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionalnrodocumento()), GXutil.trim( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionalcorreo()), GXv_boolean1, GXv_boolean2) ;
         prcsavedatamedicos.this.AV8isExisteProfesional = GXv_boolean1[0] ;
         prcsavedatamedicos.this.AV9isExisteUser = GXv_boolean2[0] ;
         if ( ! AV8isExisteProfesional || ! AV9isExisteUser )
         {
            AV17SecUser = (com.projectthani.wwpbaseobjects.SdtSecUser)new com.projectthani.wwpbaseobjects.SdtSecUser( remoteHandle, context);
            AV16SecUserRole = (com.projectthani.wwpbaseobjects.SdtSecUserRole)new com.projectthani.wwpbaseobjects.SdtSecUserRole( remoteHandle, context);
            AV18Profesional = (com.projectthani.SdtProfesional)new com.projectthani.SdtProfesional( remoteHandle, context);
            AV17SecUser.setgxTv_SdtSecUser_Secusername( GXutil.trim( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionalnrodocumento()) );
            AV17SecUser.setgxTv_SdtSecUser_Secuseremail( GXutil.trim( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionalcorreo()) );
            AV20ValorGenerarPassword = GXutil.trim( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionalapellidopaterno()) + GXutil.trim( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionalnrodocumento()) + GXutil.trim( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionalapellidomaterno()) ;
            GXv_char3[0] = AV19PasswordProfesional ;
            new com.projectthani.prcgenerarpasswordimport(remoteHandle, context).execute( AV20ValorGenerarPassword, GXv_char3) ;
            prcsavedatamedicos.this.AV19PasswordProfesional = GXv_char3[0] ;
            AV17SecUser.setgxTv_SdtSecUser_Secuserpassword( AV19PasswordProfesional );
            AV17SecUser.Save();
            if ( AV17SecUser.Success() )
            {
               AV16SecUserRole.setgxTv_SdtSecUserRole_Secuserid( AV17SecUser.getgxTv_SdtSecUser_Secuserid() );
               /* Using cursor P005Z2 */
               pr_default.execute(0);
               while ( (pr_default.getStatus(0) != 101) )
               {
                  A13SecRoleName = P005Z2_A13SecRoleName[0] ;
                  A4SecRoleId = P005Z2_A4SecRoleId[0] ;
                  AV16SecUserRole.setgxTv_SdtSecUserRole_Secroleid( A4SecRoleId );
                  pr_default.readNext(0);
               }
               pr_default.close(0);
               AV16SecUserRole.Save();
               AV18Profesional.setgxTv_SdtProfesional_Profesionalnombres( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionalnombres() );
               AV18Profesional.setgxTv_SdtProfesional_Profesionalapellidopaterno( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionalapellidopaterno() );
               AV18Profesional.setgxTv_SdtProfesional_Profesionalapellidomaterno( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionalapellidomaterno() );
               AV18Profesional.setgxTv_SdtProfesional_Profesionaltipodocumento( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionaltipodocumento() );
               AV18Profesional.setgxTv_SdtProfesional_Profesionalnrodocumento( GXutil.trim( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionalnrodocumento()) );
               AV18Profesional.setgxTv_SdtProfesional_Profesionalfechanacimiento( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionalfechanacimiento() );
               AV18Profesional.setgxTv_SdtProfesional_Profesionalsexo( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionalsexo() );
               AV18Profesional.setgxTv_SdtProfesional_Profesionalcorreo( GXutil.trim( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionalcorreo()) );
               AV18Profesional.setgxTv_SdtProfesional_Profesionaldireccion( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionaldireccion() );
               AV18Profesional.setgxTv_SdtProfesional_Profesionaldescripcion( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionaldescripcion() );
               AV18Profesional.setgxTv_SdtProfesional_Profesionalcolorcita( "#376A4A" );
               AV18Profesional.setgxTv_SdtProfesional_Profesionalcolordisponible( "#8CE1B3" );
               AV18Profesional.setgxTv_SdtProfesional_Profesionalcop( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionalcop() );
               AV18Profesional.setgxTv_SdtProfesional_Profesionaltiempocita( (byte)(30) );
               AV18Profesional.setgxTv_SdtProfesional_Profesionalfecharegistro( Gx_date );
               AV18Profesional.setgxTv_SdtProfesional_Profesionaltelefono( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionaltelefono() );
               AV18Profesional.setgxTv_SdtProfesional_Paisid( (short)(28) );
               AV18Profesional.setgxTv_SdtProfesional_Profesionalestado( "P" );
               AV18Profesional.setgxTv_SdtProfesional_Profesionalestadocuenta( "CV" );
               AV18Profesional.setgxTv_SdtProfesional_Secuserid( AV17SecUser.getgxTv_SdtSecUser_Secuserid() );
               AV18Profesional.setgxTv_SdtProfesional_Profesionalfacebook( "" );
               AV18Profesional.setgxTv_SdtProfesional_Profesionaltwitter( "" );
               AV18Profesional.setgxTv_SdtProfesional_Profesionallinkedin( "" );
               AV18Profesional.setgxTv_SdtProfesional_Profesionalinstagram( "" );
               AV18Profesional.setgxTv_SdtProfesional_Profesionalterminoscondiciones( GXutil.toBoolean( 1) );
               AV18Profesional.Save();
               if ( AV18Profesional.Success() )
               {
                  AV11RegistroNuevo = (short)(AV11RegistroNuevo+1) ;
                  new com.projectthani.prcactivarcuentaprofesional(remoteHandle, context).execute( AV18Profesional.getgxTv_SdtProfesional_Profesionalid()) ;
                  Application.commitDataStores(context, remoteHandle, pr_default, "prcsavedatamedicos");
               }
            }
         }
         else
         {
            AV15SDTImportMedicoErrorItem = (com.projectthani.SdtSDTImportMedicoError)new com.projectthani.SdtSDTImportMedicoError(remoteHandle, context);
            AV15SDTImportMedicoErrorItem.setgxTv_SdtSDTImportMedicoError_Profesionalnombres( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionalnombres() );
            AV15SDTImportMedicoErrorItem.setgxTv_SdtSDTImportMedicoError_Profesionalapellidopaterno( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionalapellidopaterno() );
            AV15SDTImportMedicoErrorItem.setgxTv_SdtSDTImportMedicoError_Profesionalapellidomaterno( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionalapellidomaterno() );
            AV15SDTImportMedicoErrorItem.setgxTv_SdtSDTImportMedicoError_Profesionaltipodocumento( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionaltipodocumento() );
            AV15SDTImportMedicoErrorItem.setgxTv_SdtSDTImportMedicoError_Profesionalnrodocumento( GXutil.trim( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionalnrodocumento()) );
            AV15SDTImportMedicoErrorItem.setgxTv_SdtSDTImportMedicoError_Profesionalfechanacimiento( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionalfechanacimiento() );
            AV15SDTImportMedicoErrorItem.setgxTv_SdtSDTImportMedicoError_Profesionalsexo( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionalsexo() );
            AV15SDTImportMedicoErrorItem.setgxTv_SdtSDTImportMedicoError_Profesionalcorreo( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionalcorreo() );
            AV15SDTImportMedicoErrorItem.setgxTv_SdtSDTImportMedicoError_Profesionaldireccion( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionaldireccion() );
            AV15SDTImportMedicoErrorItem.setgxTv_SdtSDTImportMedicoError_Profesionaldescripcion( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionaldescripcion() );
            AV15SDTImportMedicoErrorItem.setgxTv_SdtSDTImportMedicoError_Profesionalcop( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionalcop() );
            AV15SDTImportMedicoErrorItem.setgxTv_SdtSDTImportMedicoError_Profesionalfecharegistro( Gx_date );
            AV15SDTImportMedicoErrorItem.setgxTv_SdtSDTImportMedicoError_Profesionaltelefono( AV12SDTImportMedicoItem.getgxTv_SdtSDTImportMedico_Profesionaltelefono() );
            AV14SDTImportMedicoErrorList.add(AV15SDTImportMedicoErrorItem, 0);
            AV10RegistroExiste = (short)(AV10RegistroExiste+1) ;
         }
         AV23GXV1 = (int)(AV23GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcsavedatamedicos.this.AV14SDTImportMedicoErrorList;
      this.aP2[0] = prcsavedatamedicos.this.AV11RegistroNuevo;
      this.aP3[0] = prcsavedatamedicos.this.AV10RegistroExiste;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14SDTImportMedicoErrorList = new GXBaseCollection<com.projectthani.SdtSDTImportMedicoError>(com.projectthani.SdtSDTImportMedicoError.class, "SDTImportMedicoError", "ProjectThani", remoteHandle);
      AV12SDTImportMedicoItem = new com.projectthani.SdtSDTImportMedico(remoteHandle, context);
      GXv_boolean1 = new boolean[1] ;
      GXv_boolean2 = new boolean[1] ;
      AV17SecUser = new com.projectthani.wwpbaseobjects.SdtSecUser(remoteHandle);
      AV16SecUserRole = new com.projectthani.wwpbaseobjects.SdtSecUserRole(remoteHandle);
      AV18Profesional = new com.projectthani.SdtProfesional(remoteHandle);
      AV20ValorGenerarPassword = "" ;
      AV19PasswordProfesional = "" ;
      GXv_char3 = new String[1] ;
      scmdbuf = "" ;
      P005Z2_A13SecRoleName = new String[] {""} ;
      P005Z2_A4SecRoleId = new short[1] ;
      A13SecRoleName = "" ;
      Gx_date = GXutil.nullDate() ;
      AV15SDTImportMedicoErrorItem = new com.projectthani.SdtSDTImportMedicoError(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcsavedatamedicos__default(),
         new Object[] {
             new Object[] {
            P005Z2_A13SecRoleName, P005Z2_A4SecRoleId
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
   }

   private short AV11RegistroNuevo ;
   private short AV10RegistroExiste ;
   private short A4SecRoleId ;
   private short Gx_err ;
   private int AV23GXV1 ;
   private String GXv_char3[] ;
   private String scmdbuf ;
   private java.util.Date Gx_date ;
   private boolean AV8isExisteProfesional ;
   private boolean GXv_boolean1[] ;
   private boolean AV9isExisteUser ;
   private boolean GXv_boolean2[] ;
   private String AV20ValorGenerarPassword ;
   private String AV19PasswordProfesional ;
   private String A13SecRoleName ;
   private short[] aP3 ;
   private GXBaseCollection<com.projectthani.SdtSDTImportMedicoError>[] aP1 ;
   private short[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P005Z2_A13SecRoleName ;
   private short[] P005Z2_A4SecRoleId ;
   private GXBaseCollection<com.projectthani.SdtSDTImportMedico> AV13SDTImportMedicoList ;
   private GXBaseCollection<com.projectthani.SdtSDTImportMedicoError> AV14SDTImportMedicoErrorList ;
   private com.projectthani.SdtSDTImportMedico AV12SDTImportMedicoItem ;
   private com.projectthani.SdtSDTImportMedicoError AV15SDTImportMedicoErrorItem ;
   private com.projectthani.wwpbaseobjects.SdtSecUserRole AV16SecUserRole ;
   private com.projectthani.wwpbaseobjects.SdtSecUser AV17SecUser ;
   private com.projectthani.SdtProfesional AV18Profesional ;
}

final  class prcsavedatamedicos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P005Z2", "SELECT [SecRoleName], [SecRoleId] FROM [SecRole] WHERE [SecRoleName] = 'Doctor' ORDER BY [SecRoleId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
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

