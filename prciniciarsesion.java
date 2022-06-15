package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prciniciarsesion extends GXProcedure
{
   public prciniciarsesion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prciniciarsesion.class ), "" );
   }

   public prciniciarsesion( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             short[] aP3 )
   {
      prciniciarsesion.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        short[] aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             short[] aP3 ,
                             String[] aP4 )
   {
      prciniciarsesion.this.AV21SecUserName = aP0;
      prciniciarsesion.this.AV22SecUserPassword = aP1;
      prciniciarsesion.this.AV13PerfilUsuario = aP2;
      prciniciarsesion.this.aP3 = aP3;
      prciniciarsesion.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10LogInSuccessful = false ;
      AV18SecRolName = "" ;
      AV16Resultado = "" ;
      AV8EstadoUser = "" ;
      /* Using cursor P005Q2 */
      pr_default.execute(0, new Object[] {AV21SecUserName, AV21SecUserName, AV22SecUserPassword});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A15SecUserPassword = P005Q2_A15SecUserPassword[0] ;
         A122SecUserEmail = P005Q2_A122SecUserEmail[0] ;
         A14SecUserName = P005Q2_A14SecUserName[0] ;
         A6SecUserId = P005Q2_A6SecUserId[0] ;
         n6SecUserId = P005Q2_n6SecUserId[0] ;
         AV20SecUserId = A6SecUserId ;
         AV10LogInSuccessful = true ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      /* Using cursor P005Q3 */
      pr_default.execute(1, new Object[] {Short.valueOf(AV20SecUserId)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A6SecUserId = P005Q3_A6SecUserId[0] ;
         n6SecUserId = P005Q3_n6SecUserId[0] ;
         A4SecRoleId = P005Q3_A4SecRoleId[0] ;
         AV17SecRolId = A4SecRoleId ;
         pr_default.readNext(1);
      }
      pr_default.close(1);
      /* Using cursor P005Q4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV17SecRolId)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A4SecRoleId = P005Q4_A4SecRoleId[0] ;
         A13SecRoleName = P005Q4_A13SecRoleName[0] ;
         AV18SecRolName = A13SecRoleName ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(2);
      if ( GXutil.strcmp(AV18SecRolName, "Paciente") == 0 )
      {
         /* Using cursor P005Q5 */
         pr_default.execute(3, new Object[] {Short.valueOf(AV20SecUserId)});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A6SecUserId = P005Q5_A6SecUserId[0] ;
            n6SecUserId = P005Q5_n6SecUserId[0] ;
            A219PacienteEstado = P005Q5_A219PacienteEstado[0] ;
            A20PacienteId = P005Q5_A20PacienteId[0] ;
            AV8EstadoUser = A219PacienteEstado ;
            AV12PacienteId = A20PacienteId ;
            pr_default.readNext(3);
         }
         pr_default.close(3);
      }
      else if ( GXutil.strcmp(AV18SecRolName, "Doctor") == 0 )
      {
         /* Using cursor P005Q6 */
         pr_default.execute(4, new Object[] {Short.valueOf(AV20SecUserId)});
         while ( (pr_default.getStatus(4) != 101) )
         {
            A6SecUserId = P005Q6_A6SecUserId[0] ;
            n6SecUserId = P005Q6_n6SecUserId[0] ;
            A198ProfesionalEstado = P005Q6_A198ProfesionalEstado[0] ;
            A31ProfesionalId = P005Q6_A31ProfesionalId[0] ;
            AV8EstadoUser = A198ProfesionalEstado ;
            AV15ProfesionalId = A31ProfesionalId ;
            pr_default.readNext(4);
         }
         pr_default.close(4);
      }
      else if ( GXutil.strcmp(AV18SecRolName, "Administrator") == 0 )
      {
         AV8EstadoUser = "Administrator" ;
      }
      if ( AV10LogInSuccessful )
      {
         if ( GXutil.strcmp(AV13PerfilUsuario, "Doctor") == 0 )
         {
            if ( ( GXutil.strcmp(AV18SecRolName, AV13PerfilUsuario) != 0 ) && ( GXutil.strcmp(AV18SecRolName, "Paciente") == 0 ) )
            {
               AV16Resultado = "PerfilError" ;
            }
            else if ( GXutil.strcmp(AV8EstadoUser, "P") == 0 )
            {
               AV16Resultado = "Pendiente" ;
            }
            else if ( GXutil.strcmp(AV8EstadoUser, "I") == 0 )
            {
               AV16Resultado = "Inactivo" ;
            }
            else if ( ( GXutil.strcmp(AV8EstadoUser, "A") == 0 ) && ( GXutil.strcmp(AV18SecRolName, "Doctor") == 0 ) )
            {
               AV16Resultado = "ActivoProf" ;
               AV14Profesional.Load(AV15ProfesionalId);
               AV23WebSession.setValue("WSProfesionalId", GXutil.str( AV14Profesional.getgxTv_SdtProfesional_Profesionalid(), 8, 0));
               AV23WebSession.setValue("WSProfesionalDatos", AV14Profesional.getgxTv_SdtProfesional_Profesionalnombres()+" "+AV14Profesional.getgxTv_SdtProfesional_Profesionalapellidopaterno()+" "+AV14Profesional.getgxTv_SdtProfesional_Profesionalapellidomaterno());
            }
            else if ( ( GXutil.strcmp(AV8EstadoUser, "Administrator") == 0 ) && ( GXutil.strcmp(AV18SecRolName, "Administrator") == 0 ) )
            {
               AV16Resultado = "Administrator" ;
            }
            else
            {
               AV16Resultado = "Error" ;
            }
         }
         else if ( GXutil.strcmp(AV13PerfilUsuario, "Paciente") == 0 )
         {
            if ( ( GXutil.strcmp(AV18SecRolName, AV13PerfilUsuario) != 0 ) && ( GXutil.strcmp(AV18SecRolName, "Doctor") == 0 ) )
            {
               AV16Resultado = "PerfilError" ;
            }
            else if ( GXutil.strcmp(AV8EstadoUser, "P") == 0 )
            {
               AV16Resultado = "Pendiente" ;
            }
            else if ( GXutil.strcmp(AV8EstadoUser, "I") == 0 )
            {
               AV16Resultado = "Inactivo" ;
            }
            else if ( ( GXutil.strcmp(AV8EstadoUser, "A") == 0 ) && ( GXutil.strcmp(AV18SecRolName, "Paciente") == 0 ) )
            {
               AV16Resultado = "ActivoPac" ;
               AV11Paciente.Load(AV12PacienteId);
               AV23WebSession.setValue("WSPacienteId", GXutil.str( AV11Paciente.getgxTv_SdtPaciente_Pacienteid(), 8, 0));
               AV23WebSession.setValue("WSPacienteDatos", AV11Paciente.getgxTv_SdtPaciente_Pacientenombres()+" "+AV11Paciente.getgxTv_SdtPaciente_Pacienteapellidopaterno()+" "+AV11Paciente.getgxTv_SdtPaciente_Pacienteapellidomaterno());
            }
            else if ( ( GXutil.strcmp(AV8EstadoUser, "Administrator") == 0 ) && ( GXutil.strcmp(AV18SecRolName, "Administrator") == 0 ) )
            {
               AV16Resultado = "Administrator" ;
            }
            else
            {
               AV16Resultado = "Error" ;
            }
         }
      }
      else
      {
         AV16Resultado = "Error" ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = prciniciarsesion.this.AV20SecUserId;
      this.aP4[0] = prciniciarsesion.this.AV16Resultado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16Resultado = "" ;
      AV18SecRolName = "" ;
      AV8EstadoUser = "" ;
      scmdbuf = "" ;
      P005Q2_A15SecUserPassword = new String[] {""} ;
      P005Q2_A122SecUserEmail = new String[] {""} ;
      P005Q2_A14SecUserName = new String[] {""} ;
      P005Q2_A6SecUserId = new short[1] ;
      P005Q2_n6SecUserId = new boolean[] {false} ;
      A15SecUserPassword = "" ;
      A122SecUserEmail = "" ;
      A14SecUserName = "" ;
      P005Q3_A6SecUserId = new short[1] ;
      P005Q3_n6SecUserId = new boolean[] {false} ;
      P005Q3_A4SecRoleId = new short[1] ;
      P005Q4_A4SecRoleId = new short[1] ;
      P005Q4_A13SecRoleName = new String[] {""} ;
      A13SecRoleName = "" ;
      P005Q5_A6SecUserId = new short[1] ;
      P005Q5_n6SecUserId = new boolean[] {false} ;
      P005Q5_A219PacienteEstado = new String[] {""} ;
      P005Q5_A20PacienteId = new int[1] ;
      A219PacienteEstado = "" ;
      P005Q6_A6SecUserId = new short[1] ;
      P005Q6_n6SecUserId = new boolean[] {false} ;
      P005Q6_A198ProfesionalEstado = new String[] {""} ;
      P005Q6_A31ProfesionalId = new int[1] ;
      A198ProfesionalEstado = "" ;
      AV14Profesional = new com.projectthani.SdtProfesional(remoteHandle);
      AV23WebSession = httpContext.getWebSession();
      AV11Paciente = new com.projectthani.SdtPaciente(remoteHandle);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prciniciarsesion__default(),
         new Object[] {
             new Object[] {
            P005Q2_A15SecUserPassword, P005Q2_A122SecUserEmail, P005Q2_A14SecUserName, P005Q2_A6SecUserId
            }
            , new Object[] {
            P005Q3_A6SecUserId, P005Q3_A4SecRoleId
            }
            , new Object[] {
            P005Q4_A4SecRoleId, P005Q4_A13SecRoleName
            }
            , new Object[] {
            P005Q5_A6SecUserId, P005Q5_n6SecUserId, P005Q5_A219PacienteEstado, P005Q5_A20PacienteId
            }
            , new Object[] {
            P005Q6_A6SecUserId, P005Q6_A198ProfesionalEstado, P005Q6_A31ProfesionalId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV20SecUserId ;
   private short A6SecUserId ;
   private short A4SecRoleId ;
   private short Gx_err ;
   private int AV17SecRolId ;
   private int A20PacienteId ;
   private int AV12PacienteId ;
   private int A31ProfesionalId ;
   private int AV15ProfesionalId ;
   private String AV16Resultado ;
   private String AV8EstadoUser ;
   private String scmdbuf ;
   private String A219PacienteEstado ;
   private String A198ProfesionalEstado ;
   private boolean AV10LogInSuccessful ;
   private boolean n6SecUserId ;
   private String AV21SecUserName ;
   private String AV22SecUserPassword ;
   private String AV13PerfilUsuario ;
   private String AV18SecRolName ;
   private String A15SecUserPassword ;
   private String A122SecUserEmail ;
   private String A14SecUserName ;
   private String A13SecRoleName ;
   private String[] aP4 ;
   private short[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P005Q2_A15SecUserPassword ;
   private String[] P005Q2_A122SecUserEmail ;
   private String[] P005Q2_A14SecUserName ;
   private short[] P005Q2_A6SecUserId ;
   private boolean[] P005Q2_n6SecUserId ;
   private short[] P005Q3_A6SecUserId ;
   private boolean[] P005Q3_n6SecUserId ;
   private short[] P005Q3_A4SecRoleId ;
   private short[] P005Q4_A4SecRoleId ;
   private String[] P005Q4_A13SecRoleName ;
   private short[] P005Q5_A6SecUserId ;
   private boolean[] P005Q5_n6SecUserId ;
   private String[] P005Q5_A219PacienteEstado ;
   private int[] P005Q5_A20PacienteId ;
   private short[] P005Q6_A6SecUserId ;
   private boolean[] P005Q6_n6SecUserId ;
   private String[] P005Q6_A198ProfesionalEstado ;
   private int[] P005Q6_A31ProfesionalId ;
   private com.genexus.webpanels.WebSession AV23WebSession ;
   private com.projectthani.SdtPaciente AV11Paciente ;
   private com.projectthani.SdtProfesional AV14Profesional ;
}

final  class prciniciarsesion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P005Q2", "SELECT [SecUserPassword], [SecUserEmail], [SecUserName], [SecUserId] FROM [SecUser] WHERE ([SecUserName] = ? or [SecUserEmail] = ?) AND ([SecUserPassword] = ?) ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P005Q3", "SELECT [SecUserId], [SecRoleId] FROM [SecUserRole] WHERE [SecUserId] = ? ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P005Q4", "SELECT [SecRoleId], [SecRoleName] FROM [SecRole] WHERE [SecRoleId] = ? ORDER BY [SecRoleId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P005Q5", "SELECT [SecUserId], [PacienteEstado], [PacienteId] FROM [Paciente] WHERE [SecUserId] = ? ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P005Q6", "SELECT [SecUserId], [ProfesionalEstado], [ProfesionalId] FROM [Profesional] WHERE [SecUserId] = ? ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 1);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
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
               stmt.setVarchar(1, (String)parms[0], 100);
               stmt.setVarchar(2, (String)parms[1], 100);
               stmt.setVarchar(3, (String)parms[2], 100);
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

