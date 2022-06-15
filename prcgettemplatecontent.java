package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgettemplatecontent extends GXProcedure
{
   public prcgettemplatecontent( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgettemplatecontent.class ), "" );
   }

   public prcgettemplatecontent( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      prcgettemplatecontent.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      prcgettemplatecontent.this.AV8TemplateCode = aP0;
      prcgettemplatecontent.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00402 */
      pr_default.execute(0, new Object[] {AV8TemplateCode});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A291TemplateCode = P00402_A291TemplateCode[0] ;
         A292TemplateContent = P00402_A292TemplateContent[0] ;
         A53TemplateId = P00402_A53TemplateId[0] ;
         AV9TemplateContent = A292TemplateContent ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcgettemplatecontent.this.AV9TemplateContent;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9TemplateContent = "" ;
      scmdbuf = "" ;
      P00402_A291TemplateCode = new String[] {""} ;
      P00402_A292TemplateContent = new String[] {""} ;
      P00402_A53TemplateId = new short[1] ;
      A291TemplateCode = "" ;
      A292TemplateContent = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcgettemplatecontent__default(),
         new Object[] {
             new Object[] {
            P00402_A291TemplateCode, P00402_A292TemplateContent, P00402_A53TemplateId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A53TemplateId ;
   private short Gx_err ;
   private String scmdbuf ;
   private String AV9TemplateContent ;
   private String A292TemplateContent ;
   private String AV8TemplateCode ;
   private String A291TemplateCode ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P00402_A291TemplateCode ;
   private String[] P00402_A292TemplateContent ;
   private short[] P00402_A53TemplateId ;
}

final  class prcgettemplatecontent__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00402", "SELECT TOP 1 [TemplateCode], [TemplateContent], [TemplateId] FROM [Template] WHERE [TemplateCode] = ? ORDER BY [TemplateId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
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
               return;
      }
   }

}

