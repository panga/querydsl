/*
 * Copyright (c) 2010 Mysema Ltd.
 * All rights reserved.
 *
 */
package com.mysema.query.sql.ddl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysema.query.QueryException;
import com.mysema.query.sql.SQLTemplates;

import edu.umd.cs.findbugs.annotations.SuppressWarnings;

/**
 * DropTableClause defines a DROP TABLE clause
 * 
 * @author tiwe
 *
 */
public class DropTableClause {

    private final Connection connection;
    
    private final String table;
    
    public DropTableClause(Connection conn, SQLTemplates templates, String table) {
        this.connection = conn;
        this.table = templates.quoteTableName(table);
    }
    
    @SuppressWarnings("SQL_NONCONSTANT_STRING_PASSED_TO_EXECUTE")
    public void execute(){
        Statement stmt = null;
        try{
            stmt = connection.createStatement();
            stmt.execute("DROP TABLE " + table);
        } catch (SQLException e) {
            // do not rethrow
        }finally{
            if (stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new QueryException(e);
                }
            }            
        }  
    }
    
}