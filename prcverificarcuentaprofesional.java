package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcverificarcuentaprofesional extends GXProcedure
{
   public prcverificarcuentaprofesional( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcverificarcuentaprofesional.class ), "" );
   }

   public prcverificarcuentaprofesional( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      prcverificarcuentaprofesional.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 )
   {
      prcverificarcuentaprofesional.this.AV11ProfesionalId = aP0;
      prcverificarcuentaprofesional.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P007O3 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11ProfesionalId)});
      if ( (pr_default.getStatus(0) != 101) )
      {
         A40000ProfesionalId = P007O3_A40000ProfesionalId[0] ;
         n40000ProfesionalId = P007O3_n40000ProfesionalId[0] ;
      }
      else
      {
         A40000ProfesionalId = 0 ;
         n40000ProfesionalId = false ;
      }
      pr_default.close(0);
      AV10Profesional.Load(A40000ProfesionalId);
      AV9idProfesional = AV10Profesional.getgxTv_SdtProfesional_Profesionalid() ;
      if ( AV9idProfesional > 0 )
      {
         AV10Profesional.setgxTv_SdtProfesional_Profesionalestado( "A" );
         AV10Profesional.Update();
         if ( AV10Profesional.Success() )
         {
            Application.commitDataStores(context, remoteHandle, pr_default, "prcverificarcuentaprofesional");
            new com.projectthani.prcbienvenidaprofesional(remoteHandle, context).execute( AV11ProfesionalId) ;
            AV8Error = "Ok" ;
         }
         else
         {
            AV8Error = "Error" ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcverificarcuentaprofesional.this.AV8Error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8Error = "" ;
      scmdbuf = "" ;
      P007O3_A40000ProfesionalId = new int[1] ;
      P007O3_n40000ProfesionalId = new boolean[] {false} ;
      AV10Profesional = new com.projectthani.SdtProfesional(remoteHandle);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcverificarcuentaprofesional__default(),
         new Object[] {
             new Object[] {
            P007O3_A40000ProfesionalId, P007O3_n40000ProfesionalId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV11ProfesionalId ;
   private int A40000ProfesionalId ;
   private int AV9idProfesional ;
   private String AV8Error ;
   private String scmdbuf ;
   private boolean n40000ProfesionalId ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P007O3_A40000ProfesionalId ;
   private boolean[] P007O3_n40000ProfesionalId ;
   private com.projectthani.SdtProfesional AV10Profesional ;
}

final  class prcverificarcuentaprofesional__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007O3", "SELECT COALESCE( T1.[ProfesionalId], 0) AS ProfesionalId FROM (SELECT [ProfesionalId] AS ProfesionalId FROM [Profesional] WHERE [ProfesionalId] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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

