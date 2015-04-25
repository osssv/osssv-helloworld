class PollsHookListener < Redmine::Hook::ViewListener
	render_on :view_projects_show_left, :partial => "polls/project_overview"
end
