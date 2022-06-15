package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcconfirmarcuentapaciente extends GXProcedure
{
   public prcconfirmarcuentapaciente( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcconfirmarcuentapaciente.class ), "" );
   }

   public prcconfirmarcuentapaciente( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String[] aP1 ,
                             String[] aP2 ,
                             String[] aP3 )
   {
      prcconfirmarcuentapaciente.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 ,
                        String[] aP2 ,
                        String[] aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 ,
                             String[] aP2 ,
                             String[] aP3 ,
                             String[] aP4 )
   {
      prcconfirmarcuentapaciente.this.AV14PacienteId = aP0;
      prcconfirmarcuentapaciente.this.aP1 = aP1;
      prcconfirmarcuentapaciente.this.aP2 = aP2;
      prcconfirmarcuentapaciente.this.aP3 = aP3;
      prcconfirmarcuentapaciente.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P005S3 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV14PacienteId)});
      if ( (pr_default.getStatus(0) != 101) )
      {
         A40000PacienteId = P005S3_A40000PacienteId[0] ;
         n40000PacienteId = P005S3_n40000PacienteId[0] ;
      }
      else
      {
         A40000PacienteId = 0 ;
         n40000PacienteId = false ;
      }
      pr_default.close(0);
      AV13Paciente.Load(A40000PacienteId);
      AV14PacienteId = AV13Paciente.getgxTv_SdtPaciente_Pacienteid() ;
      AV12PacienteNombres = AV13Paciente.getgxTv_SdtPaciente_Pacientenombres() ;
      AV9PacienteApellidoPaterno = AV13Paciente.getgxTv_SdtPaciente_Pacienteapellidopaterno() ;
      AV8PacienteApellidoMaterno = AV13Paciente.getgxTv_SdtPaciente_Pacienteapellidopaterno() ;
      AV10PacienteCorreo = AV13Paciente.getgxTv_SdtPaciente_Pacientecorreo() ;
      AV11PacienteEstado = AV13Paciente.getgxTv_SdtPaciente_Pacienteestado() ;
      AV17PacienteSexo = AV13Paciente.getgxTv_SdtPaciente_Pacientesexo() ;
      AV15PacienteNombresApellidos = AV12PacienteNombres + " " + AV9PacienteApellidoPaterno + " " + AV8PacienteApellidoMaterno ;
      if ( AV14PacienteId > 0 )
      {
         if ( GXutil.strcmp(AV11PacienteEstado, "P") == 0 )
         {
            AV13Paciente.setgxTv_SdtPaciente_Pacienteestado( "A" );
            AV13Paciente.Update();
            if ( AV13Paciente.Success() )
            {
               Application.commitDataStores(context, remoteHandle, pr_default, "prcconfirmarcuentapaciente");
               new com.projectthani.prcbienvenidapaciente(remoteHandle, context).execute( AV13Paciente.getgxTv_SdtPaciente_Pacienteid()) ;
               AV16ResultadoEstado = "Pendiente" ;
            }
         }
         else if ( GXutil.strcmp(AV11PacienteEstado, "A") == 0 )
         {
            AV16ResultadoEstado = "Activo" ;
         }
         else
         {
            AV16ResultadoEstado = "Inactivo" ;
         }
      }
      else
      {
         httpContext.GX_msglist.addItem("Error, no existe el registro");
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcconfirmarcuentapaciente.this.AV15PacienteNombresApellidos;
      this.aP2[0] = prcconfirmarcuentapaciente.this.AV10PacienteCorreo;
      this.aP3[0] = prcconfirmarcuentapaciente.this.AV17PacienteSexo;
      this.aP4[0] = prcconfirmarcuentapaciente.this.AV16ResultadoEstado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15PacienteNombresApellidos = "" ;
      AV10PacienteCorreo = "" ;
      AV17PacienteSexo = "" ;
      AV16ResultadoEstado = "" ;
      scmdbuf = "" ;
      P005S3_A40000PacienteId = new int[1] ;
      P005S3_n40000PacienteId = new boolean[] {false} ;
      AV13Paciente = new com.projectthani.SdtPaciente(remoteHandle);
      AV12PacienteNombres = "" ;
      AV9PacienteApellidoPaterno = "" ;
      AV8PacienteApellidoMaterno = "" ;
      AV11PacienteEstado = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcconfirmarcuentapaciente__default(),
         new Object[] {
             new Object[] {
            P005S3_A40000PacienteId, P005S3_n40000PacienteId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV14PacienteId ;
   private int A40000PacienteId ;
   private String AV17PacienteSexo ;
   private String AV16ResultadoEstado ;
   private String scmdbuf ;
   private String AV11PacienteEstado ;
   private boolean n40000PacienteId ;
   private String AV15PacienteNombresApellidos ;
   private String AV10PacienteCorreo ;
   private String AV12PacienteNombres ;
   private String AV9PacienteApellidoPaterno ;
   private String AV8PacienteApellidoMaterno ;
   private String[] aP4 ;
   private String[] aP1 ;
   private String[] aP2 ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P005S3_A40000PacienteId ;
   private boolean[] P005S3_n40000PacienteId ;
   private com.projectthani.SdtPaciente AV13Paciente ;
}

final  class prcconfirmarcuentapaciente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P005S3", "SELECT COALESCE( T1.[PacienteId], 0) AS PacienteId FROM (SELECT [PacienteId] AS PacienteId FROM [Paciente] WHERE [PacienteId] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
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

