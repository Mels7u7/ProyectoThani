package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcconfirmarcuentaprofesional extends GXProcedure
{
   public prcconfirmarcuentaprofesional( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcconfirmarcuentaprofesional.class ), "" );
   }

   public prcconfirmarcuentaprofesional( int remoteHandle ,
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
      prcconfirmarcuentaprofesional.this.aP4 = new String[] {""};
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
      prcconfirmarcuentaprofesional.this.AV13ProfesionalId = aP0;
      prcconfirmarcuentaprofesional.this.aP1 = aP1;
      prcconfirmarcuentaprofesional.this.aP2 = aP2;
      prcconfirmarcuentaprofesional.this.aP3 = aP3;
      prcconfirmarcuentaprofesional.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P007L3 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13ProfesionalId)});
      if ( (pr_default.getStatus(0) != 101) )
      {
         A40000ProfesionalId = P007L3_A40000ProfesionalId[0] ;
         n40000ProfesionalId = P007L3_n40000ProfesionalId[0] ;
      }
      else
      {
         A40000ProfesionalId = 0 ;
         n40000ProfesionalId = false ;
      }
      pr_default.close(0);
      AV8Profesional.Load(A40000ProfesionalId);
      AV13ProfesionalId = AV8Profesional.getgxTv_SdtProfesional_Profesionalid() ;
      AV14ProfesionalNombres = AV8Profesional.getgxTv_SdtProfesional_Profesionalnombres() ;
      AV10ProfesionalApellidoPaterno = AV8Profesional.getgxTv_SdtProfesional_Profesionalapellidopaterno() ;
      AV9ProfesionalApellidoMaterno = AV8Profesional.getgxTv_SdtProfesional_Profesionalapellidopaterno() ;
      AV11ProfesionalCorreo = AV8Profesional.getgxTv_SdtProfesional_Profesionalcorreo() ;
      AV12ProfesionalEstado = AV8Profesional.getgxTv_SdtProfesional_Profesionalestado() ;
      AV17ProfesionalEstadoCuenta = AV8Profesional.getgxTv_SdtProfesional_Profesionalestadocuenta() ;
      AV18ProfesionalSexo = AV8Profesional.getgxTv_SdtProfesional_Profesionalsexo() ;
      AV15ProfesionalNombresApellidos = AV14ProfesionalNombres + " " + AV10ProfesionalApellidoPaterno + " " + AV9ProfesionalApellidoMaterno ;
      if ( AV13ProfesionalId > 0 )
      {
         if ( GXutil.strcmp(AV12ProfesionalEstado, "P") == 0 )
         {
            AV8Profesional.setgxTv_SdtProfesional_Profesionalestado( "A" );
            AV8Profesional.Update();
            if ( AV8Profesional.Success() )
            {
               Application.commitDataStores(context, remoteHandle, pr_default, "prcconfirmarcuentaprofesional");
               new com.projectthani.prcbienvenidaprofesional(remoteHandle, context).execute( AV8Profesional.getgxTv_SdtProfesional_Profesionalid()) ;
               AV16ResultadoEstado = "Pendiente" ;
            }
         }
         else if ( GXutil.strcmp(AV12ProfesionalEstado, "A") == 0 )
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
      this.aP1[0] = prcconfirmarcuentaprofesional.this.AV15ProfesionalNombresApellidos;
      this.aP2[0] = prcconfirmarcuentaprofesional.this.AV11ProfesionalCorreo;
      this.aP3[0] = prcconfirmarcuentaprofesional.this.AV18ProfesionalSexo;
      this.aP4[0] = prcconfirmarcuentaprofesional.this.AV16ResultadoEstado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15ProfesionalNombresApellidos = "" ;
      AV11ProfesionalCorreo = "" ;
      AV18ProfesionalSexo = "" ;
      AV16ResultadoEstado = "" ;
      scmdbuf = "" ;
      P007L3_A40000ProfesionalId = new int[1] ;
      P007L3_n40000ProfesionalId = new boolean[] {false} ;
      AV8Profesional = new com.projectthani.SdtProfesional(remoteHandle);
      AV14ProfesionalNombres = "" ;
      AV10ProfesionalApellidoPaterno = "" ;
      AV9ProfesionalApellidoMaterno = "" ;
      AV12ProfesionalEstado = "" ;
      AV17ProfesionalEstadoCuenta = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcconfirmarcuentaprofesional__default(),
         new Object[] {
             new Object[] {
            P007L3_A40000ProfesionalId, P007L3_n40000ProfesionalId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV13ProfesionalId ;
   private int A40000ProfesionalId ;
   private String AV18ProfesionalSexo ;
   private String AV16ResultadoEstado ;
   private String scmdbuf ;
   private String AV12ProfesionalEstado ;
   private String AV17ProfesionalEstadoCuenta ;
   private boolean n40000ProfesionalId ;
   private String AV15ProfesionalNombresApellidos ;
   private String AV11ProfesionalCorreo ;
   private String AV14ProfesionalNombres ;
   private String AV10ProfesionalApellidoPaterno ;
   private String AV9ProfesionalApellidoMaterno ;
   private String[] aP4 ;
   private String[] aP1 ;
   private String[] aP2 ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P007L3_A40000ProfesionalId ;
   private boolean[] P007L3_n40000ProfesionalId ;
   private com.projectthani.SdtProfesional AV8Profesional ;
}

final  class prcconfirmarcuentaprofesional__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007L3", "SELECT COALESCE( T1.[ProfesionalId], 0) AS ProfesionalId FROM (SELECT [ProfesionalId] AS ProfesionalId FROM [Profesional] WHERE [ProfesionalId] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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

