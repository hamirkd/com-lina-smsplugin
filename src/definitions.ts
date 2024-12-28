export interface smspluginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
