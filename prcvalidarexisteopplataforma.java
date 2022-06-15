package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcvalidarexisteopplataforma extends GXProcedure
{
   public prcvalidarexisteopplataforma( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcvalidarexisteopplataforma.class ), "" );
   }

   public prcvalidarexisteopplataforma( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              int aP1 )
   {
      prcvalidarexisteopplataforma.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        int aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             int aP1 ,
                             boolean[] aP2 )
   {
      prcvalidarexisteopplataforma.this.AV11PacienteId = aP0;
      prcvalidarexisteopplataforma.this.AV13CitaId = aP1;
      prcvalidarexisteopplataforma.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P008L3 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11PacienteId), Integer.valueOf(AV13CitaId)});
      if ( (pr_default.getStatus(0) != 101) )
      {
         A40000SugerenciasMejorasPlataformaId = P008L3_A40000SugerenciasMejorasPlataformaId[0] ;
         n40000SugerenciasMejorasPlataformaId = P008L3_n40000SugerenciasMejorasPlataformaId[0] ;
      }
      else
      {
         A40000SugerenciasMejorasPlataformaId = 0 ;
         n40000SugerenciasMejorasPlataformaId = false ;
      }
      pr_default.close(0);
      AV10ValId = A40000SugerenciasMejorasPlataformaId ;
      if ( AV10ValId > 0 )
      {
         AV9Val = true ;
      }
      else
      {
         AV9Val = false ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = prcvalidarexisteopplataforma.this.AV9Val;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P008L3_A40000SugerenciasMejorasPlataformaId = new int[1] ;
      P008L3_n40000SugerenciasMejorasPlataformaId = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcvalidarexisteopplataforma__default(),
         new Object[] {
             new Object[] {
            P008L3_A40000SugerenciasMejorasPlataformaId, P008L3_n40000SugerenciasMejorasPlataformaId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV11PacienteId ;
   private int AV13CitaId ;
   private int A40000SugerenciasMejorasPlataformaId ;
   private int AV10ValId ;
   private String scmdbuf ;
   private boolean AV9Val ;
   private boolean n40000SugerenciasMejorasPlataformaId ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P008L3_A40000SugerenciasMejorasPlataformaId ;
   private boolean[] P008L3_n40000SugerenciasMejorasPlataformaId ;
}

final  class prcvalidarexisteopplataforma__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P008L3", "SELECT COALESCE( T1.[SugerenciasMejorasPlataformaId], 0) AS SugerenciasMejorasPlataformaId FROM (SELECT MIN([SugerenciasMejorasPlataformaId]) AS SugerenciasMejorasPlataformaId FROM [SugerenciasMejorasPlataforma] WHERE ([SGPacientePacienteId] = ?) AND ([SugerenciasMejorasPlataformaCitaId] = ?) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
      }
   }

}

