UPDATE tasks
SET tasks.labelid=(SELECT label.id
  FROM label
  WHERE tasks.label=label.name);