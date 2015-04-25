class CreatePolls < ActiveRecord::Migration
  def up
    create_table :polls do |t|
      t.string :question
      t.integer :yes, :default => 0
      t.integer :no, :default => 0
    end
  end

  def down
	drop_table :polls
  end
end
