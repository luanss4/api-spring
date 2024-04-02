ALTER TABLE medicos ADD COLUMN ativo SMALLINT;
UPDATE medicos SET ativo = 1;