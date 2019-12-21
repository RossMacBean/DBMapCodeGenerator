# DBMapCodeGenerator
A very simple tool that generates Java database code for multiple Database vendors

This tool was created as part of a research project into the compatibility of different Database vendors by measuring how closely they follow the SQL specification.

It works by inspecting the metadata exposed by each DBMS, then generating Java wrappers to call stored procedures found in the metadata.
